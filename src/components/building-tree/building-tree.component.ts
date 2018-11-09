import { Component, OnInit, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BuildingTreeService } from '../../services/buildingTree.service';
import { BuildingTree } from 'src/models/BuildingTree';
import { TreeNode } from 'primeng/primeng';

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
  droppableAdded: boolean = false;
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
    this.addItemToThing(thing, this.selectedNode);
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
      .subscribe(response => this.buildTree(response));
  }

  buildTree(treeJson: BuildingTree) {
    let {treeFloor, things} = treeJson;

    this.tree.push({
      label: treeJson.name,
      children: this.buildingNode(treeFloor),
      ...this.nodeCommonProp
    });

    this.buildThingsTree(things);
  }

  addItemToThing(thing: any, item: any) {
    this.things = this.things.reduce((acc, thing) => {
      console.log('ciao');
      console.log(thing);
    }, []);
  }

  buildThingsTree(things: any[]) {
    this.things = things.reduce((acc, thing) => {
      let node: TreeNode = {label: thing.numUscite.toString()};
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
