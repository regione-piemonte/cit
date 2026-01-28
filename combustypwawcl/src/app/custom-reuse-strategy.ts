import { ComponentRef } from '@angular/core';
import {
    ActivatedRouteSnapshot,
    DetachedRouteHandle,
    RouteReuseStrategy,
} from '@angular/router';

export interface OnReuse {
  citOnReuse(): void;
}

export class CustomReuseStrategy implements RouteReuseStrategy {
  private storedRouteHandles = new Map<string, DetachedRouteHandle>();

  // Decides if the route should be stored
  shouldDetach(route: ActivatedRouteSnapshot): boolean {
    return route.data['reusable'];
  }

  //Store the information for the route we're destructing
  store(route: ActivatedRouteSnapshot, handle: DetachedRouteHandle): void {
    this.storedRouteHandles.set(route.routeConfig!.path!, handle);
  }

  //Return true if we have a stored route object for the next route
  shouldAttach(route: ActivatedRouteSnapshot): boolean {
    return (
      route.data['reusable'] &&
      route.fragment !== 'fresh' &&
      this.storedRouteHandles.has(route.routeConfig!.path!)
    );
  }

  //If we returned true in shouldAttach(), now return the actual route data for restoration
  retrieve(route: ActivatedRouteSnapshot): DetachedRouteHandle {
    const handle = this.storedRouteHandles.get(route.routeConfig!.path!)! as { componentRef: ComponentRef<any> };

    if (handle.componentRef.instance.citOnReuse) {
      (handle.componentRef.instance as OnReuse).citOnReuse();
    }

    return handle;
  }

  //Reuse the route if we're going to and from the same route
  shouldReuseRoute(
    future: ActivatedRouteSnapshot,
    curr: ActivatedRouteSnapshot
  ): boolean {
    return future.fragment === 'fresh'
      ? false
      : future.routeConfig === curr.routeConfig;
  }
}
