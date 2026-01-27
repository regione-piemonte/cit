export interface PointStyleI {
    /**
     * Border color of point, can be hex, rgb or rgba
     */
    featureBorderColor?: string;
    /**
     * Fill color of point, can be hex, rgb or rgba
     */
    fillColor: string;
    /**
     * Point radius
     */
    featurePointRadius?: number;
    /**
     * Show icon when is visible one single point on map
     */
    icon?: string;
    /**
     * height of the icon in pixel 
     */
    heightIcon?: number;
    /**
     * Text color inside cluster point
     */
    textColor?: string;
    /**
     * Width og border
     */
    featureBorderWidth?: number;

    /**
     * Color of the point when select
     */
    selectFillColor?: string;

    /**
     * Icon to show when feature is selected
     */
    selectIcon?: string;

    /**
     * point radius of cluster
     */
    clusterPointRadius?: number;
}

export class PointStyle {
    /**
     * Border color of point, can be hex, rgb or rgba use when show only one feature
     * @default #ffffff
     */
    featureBorderColor: string;
    /**
     * @required
     * Fill color of point, can be hex, rgb or rgba
     */
    fillColor: string;
    /**
     * Color of the point when select
     */
    selectFillColor?: string;
    /**
     * Text color inside cluster point
     * @default #000000
     */
    textColor: string;

    /**
     * Point radius of single feature
     * @default 5
     */
    featurePointRadius: number;
    /**
     * Show icon when is visible one single point on map
     */
    icon?: string;

    /**
     * Icon to show when feature is selected
     */
    selectIcon?: string;

    /**
     * height of the icon in pixel 
     * @default 20
     */
    heightIcon?: number;
    
    /**
     * Width of border use when show only one feature
     * @default 1
     */
    featureBorderWidth: number;

    /**
     * point radius of cluster
     * @default 5
     */
    clusterPointRadius: number;

    constructor(style: PointStyleI) {
        this.featureBorderColor = style?.featureBorderColor ? style.featureBorderColor : '#ffffff';
        this.fillColor = style.fillColor;
        this.featurePointRadius = style?.featurePointRadius ? style.featurePointRadius : 5;
        this.icon = style?.icon;
        this.textColor = style?.textColor ? style.textColor : '#000000';
        this.featureBorderWidth = style?.featureBorderWidth ? style.featureBorderWidth : 1;
        this.selectFillColor = style?.selectFillColor ?? style?.fillColor;
        this.heightIcon = style?.heightIcon ? style.heightIcon : 20;
        this.selectIcon = style?.selectIcon ?? style?.icon;
        this.clusterPointRadius = style.clusterPointRadius ? style.clusterPointRadius: 5;
    }

}
