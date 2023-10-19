export class SyncTask {
    constructor(
        public url: string,
        public method: string,
        public body: any,
        public params?: string) { }
}