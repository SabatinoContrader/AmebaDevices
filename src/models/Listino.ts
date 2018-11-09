import { Customer } from "./Customer";

export class Listino{
    nomeListino:string;
    anno:number;
    idManufacturer:Customer;

    constructor(nomeListino:string, anno:number, idManufacturer:Customer){
        this.nomeListino = nomeListino;
        this.anno = anno;
        this.idManufacturer = idManufacturer;
    }
}