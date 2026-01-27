export const doDownloadFile = async (elem, name, mimeType = 'application/pdf') => {
    var blob;
    if (elem instanceof Blob) {
        elem = await elem.arrayBuffer();
    } else {
        if (elem instanceof String || typeof elem === 'string') {
            elem = base64ToUint8Array(elem);
        } else if (elem instanceof ArrayBuffer) {
            //workaround
            try {
                elem = base64ToUint8Array(new TextDecoder().decode(elem));
            } catch (e) {
                elem = new Uint8Array(elem);
            }
        } else if (!(elem instanceof Uint8Array)) {
            elem = new Uint8Array(elem);
        }
    }
    blob = new Blob([elem], { type: mimeType });
    let url = window.URL.createObjectURL(blob);
    let a = document.createElement('a');
    a.href = url;
    a.download = name;
    a.click();
}

export function doDownloadFileBase64(elem, name, mimeType = 'application/pdf') {
    var blob = new Blob([base64ToUint8Array(elem)], { type: mimeType });
    let url = window.URL.createObjectURL(blob);
    let a = document.createElement('a');
    a.href = url;
    a.download = name;
    a.click();
}

export function base64ToUint8Array(base64) {
    var binaryString = atob(base64);
    var len = binaryString.length;
    var bytes = new Uint8Array(len);
    for (var i = 0; i < len; i++) {
        bytes[i] = binaryString.charCodeAt(i);
    }
    return bytes;
}

export function download(base64: string, name: string, mimeType = 'application/octet-stream'): void {
  const a = document.createElement('a');
  a.href = `data:${mimeType};base64,${base64}`;
  a.download = name;
  a.click();
}
