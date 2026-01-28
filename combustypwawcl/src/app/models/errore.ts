export class Errore {
    status: string;
    code: string;
    title: string;
    links: string[];


    constructor(
        status: string,
        code: string,
        title: string,
        links: string[]
    ) {
        this.status = status
        this.code = code
        this.title = title
        this.links = links
    }

}