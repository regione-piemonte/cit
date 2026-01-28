FROM docker-base.ecosis.csi.it/angular:12.2.12-node16-csi-r1 as build

#here copy source

COPY --chown=node:node . /app
RUN printenv
RUN ls -lat
RUN npm install
RUN npm run build

#here second stage of image
FROM alpine
LABEL it.csi.codice_progetto="sigit" \
      it.csi.codice_componente="combustypwawcl" 
      
COPY --from=build /app/dist/combustypwawcl /data

VOLUME /data
