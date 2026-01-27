import { Injectable } from "@angular/core";
import * as olColor from 'ol/color';
import {
    Circle as CircleStyle,
    Fill,
    Icon,
    Stroke,
    Style,
    Text,
} from 'ol/style';
import { PointStyle } from "src/app/models/point-style.model";

@Injectable({
    providedIn: 'root'
  })
export class FeatureStyle {

    /**
     * Opacity used on feature when user click on cluster and it explode
     */
    private selectClusterFeatureOpacity = 0.7;

    /**
     * Opacity of border of cluster
     */
    private borderOpacityCluser = 0.5;

    /**
     * Create Text style
     * @param style choosen style
     * @param label label to show on feature
     * @returns
     */
    private getTextStyle(style: PointStyle, label: string): Style {
        return new Style({
            text: new Text({
              text: label,
              fill: new Fill({
                color: style.textColor,
              }),
            }),
        });
    }

    /**
     * Create style of cluster
     * @param style choosen style
     * @param size is the number of feature that cluster has. Used to create dimension of cluster
     * @returns
     */
    private getClusterPointStyle(style: PointStyle, size: number): Style {
        // create color with opacity for border style of cluster
        const fillRgbArray = olColor.asArray(style.fillColor); // return list of color and last value is opacity
        fillRgbArray[3] = this.borderOpacityCluser;

        return new Style({
            image: new CircleStyle({
                // Radius can be dynamic in base of geojson density. To use dynamic uncomment the following
                // 5 and 30 are fixed, if smaller of 5 the point is difficult to see on map and if greater of 30 it will cover other clusters
                // radius: size <= 5 ? 5 : (size > 30 ? 30 : size),
                radius: style.clusterPointRadius,
                stroke: new Stroke({
                    color: olColor.asString(fillRgbArray),
                    width: 10,
                }),
                fill: new Fill({
                    color: style.fillColor,
                }),
            })
        })
    }

    /**
     * Return list contains cluster style and text style
     * @param style choosen style
     * @param label label to show on cluster
     * @param size size of the cluster features
     * @returns
     */
    public getClusterStyle(style: PointStyle, label: string, size: number): Style[] {
        return [this.getClusterPointStyle(style, size), this.getTextStyle(style,label)];
    }


    /**
     * Create feature style. If has icons show that otherwise show default point styled
     * @param style choosen style
     * @returns
     */
    public getFeatureStyle(style: PointStyle): Style {
        // If there is no icon show default point style
        if(!style.icon) {
            return new Style({
                image: new CircleStyle({
                    radius: style.featurePointRadius,
                    stroke: new Stroke({
                        color: style.featureBorderColor,
                        width: style.featureBorderWidth,
                    }),
                    fill: new Fill({
                        color: style.fillColor,
                    }),
                }),
                // Manage also polygon and lineString style
                fill: new Fill({
                    color: style.fillColor,
                }),
                stroke: new Stroke({
                    color: style.featureBorderColor,
                    width: style.featureBorderWidth,
                })
            })
        } else {
            return new Style({
                image: new Icon({
                    src: style.icon,
                    anchorOrigin: 'top-left',
                    anchor: [0.5, 0.5],
                    // height
                    height: style.heightIcon,
                })
            })
        }
    }

    /**
     * Create style when select feature. If has selectIcon or icon use that to show otherwise show default point styled
     * @param style choosen style
     * @returns
     */
    public getSelectedFeatureStyle(style: PointStyle): Style {
        // If there is no icon show default point style
        if(!style.selectIcon && !style.icon) {
            return new Style({
                image: new CircleStyle({
                    radius: style.featurePointRadius,
                    stroke: new Stroke({
                        color: style.featureBorderColor,
                        width: style.featureBorderWidth,
                    }),
                    fill: new Fill({
                        color: style.selectFillColor ?? style.fillColor,
                    }),
                }),
                // Manage also polygon and lineString style
                fill: new Fill({
                    color: style.selectFillColor ?? style.fillColor,
                }),
                stroke: new Stroke({
                    color: style.featureBorderColor,
                    width: style.featureBorderWidth,
                })
            });
        } else {
            return new Style({
                image: new Icon({
                  // if there is no select icon use default icon
                  src: style.selectIcon ?? style.icon,
                  anchorOrigin: 'top-left',
                  anchor: [0.5, 0.5],
                  // height
                  height: style.heightIcon,
                })
              });
        }
    }

    /**
     * Create style of feature to show when user click on cluster and isfeature expand
     * @param style choosen style
     * @returns
     */
    public getExpandedFeatureStyle(style: PointStyle): Style {

        // set opactity to border color and fill color
        const strokeRgbArray = olColor.asArray(style.featureBorderColor);
        strokeRgbArray[3] = this.selectClusterFeatureOpacity;

        const fillRgbArray = olColor.asArray(style.fillColor);
        fillRgbArray[3] = this.selectClusterFeatureOpacity;

        // If there is no icon show default point style
        if(!style.icon) {
            return new Style({
                image: new CircleStyle({
                    radius: style.featurePointRadius,
                    stroke: new Stroke({
                        color: olColor.asString(strokeRgbArray),
                        width: style.featureBorderWidth,
                    }),
                    fill: new Fill({
                        color: olColor.asString(fillRgbArray),
                    }),
                }),
                // Manage also polygon and lineString style
                fill: new Fill({
                    color: olColor.asString(fillRgbArray),
                }),
                stroke: new Stroke({
                    color: olColor.asString(strokeRgbArray),
                    width: style.featureBorderWidth,
                }),
            })
        } else {
            return new Style({
                image: new Icon({
                  src: style.icon,
                  anchorOrigin: 'top-left',
                  anchor: [0.5, 0.5],
                  // height
                  height: style.heightIcon,
                  opacity: this.selectClusterFeatureOpacity
                })
              })
        }
    }
}
