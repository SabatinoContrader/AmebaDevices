import { Component, OnInit, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BuildingTreeService } from '../../services/buildingTree.service';
import { BuildingTree } from 'src/models/BuildingTree';
import { TreeNode } from 'primeng/primeng';
import { Floor } from '../../models/Floor';

@Component({
  selector: 'app-building-tree',
  templateUrl: './building-tree.component.html',
  styleUrls: ['./building-tree.component.css']
})
export class BuildingTreeComponent implements OnInit {

  tree: TreeNode[] = [];
  things: any[];
  selectedNode: any = null;
  itemsByThing: any;
  addedItemsToTings: any[] = [];
  droppableAdded: boolean = false;
  thingsFromServer: any[];
  nodeCommonProp = {
    expandedIcon: "fa fa-folder-open",
    collapsedIcon:"fa fa-folder",
    expanded: true,
    draggable: true
  };

  constructor(
    private route: ActivatedRoute,
    private BuildingTreeService: BuildingTreeService,
    private elRef:ElementRef
    ) { }

  ngOnInit() {
    this.getBuildingTree();
  }

  drop(event) {
    let thing = event.srcElement.innerText;
    this.addedItemsToTings.push({ thing, name: this.selectedNode });
    this.buildThingsTree();
  }

  nodeSelect(event) {
    this.selectedNode = event.node.type = 'item' ? event.node.label : null;
  }

  ngAfterViewChecked() {
    let nodes: any[] = this.elRef.nativeElement.querySelectorAll('.ui-treenode-content');

    if(nodes.length > 0 && !this.droppableAdded) {
      this.addDraggableToEachNode(nodes);
    }
  }

  addDraggableToEachNode(nodes: any[]) {
    nodes.forEach(element => {
      element.setAttribute("draggable", "true");
    });
    this.droppableAdded = true;
  }

  getBuildingTree() {
    const buildingId: number = +this.route.snapshot.paramMap.get('buildingId');
    this.BuildingTreeService.getBuildingTree(buildingId)
      .subscribe(response => this.buildAllTree(response));
  }

  buildAllTree(treeJson: BuildingTree) {
    let {treeFloor, things} = treeJson;
    this.thingsFromServer = things;

    this.buildBuildingTree(treeJson.name, treeFloor);
    this.buildThingsTree();
  }

  buildBuildingTree(buildingName: string, floors: Floor[]) {
    this.tree.push({
      label: buildingName,
      children: this.buildingNode(floors),
      ...this.nodeCommonProp
    });
  }

  buildThingsTree() {
    this.things = this.thingsFromServer.reduce((acc, thing) => {
      let nodeToAdd = this.addedItemsToTings.filter(relation => thing.numUscite = relation.thing);
      let node: TreeNode = {
        label: thing.numUscite.toString(),
        ...this.nodeCommonProp
      };

      node.children = this.buildingNode(nodeToAdd);
      acc.push([node]);

      return acc;
    }, []);
  }

  buildingNode(items: any[]): TreeNode[] {
    return items.reduce((acc, item) => {
      let {name = null, children = null, type = null} = item;
      let node: TreeNode = {
        label: name,
        type: type ? type : 'father',
        ...this.nodeCommonProp
      };

      if (children) {
        node.children = this.buildingNode(children);
      }
      acc.push(node);

      return acc;
    }, <TreeNode[]>[])
  }
}
