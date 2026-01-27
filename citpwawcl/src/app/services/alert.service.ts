import { Injectable } from '@angular/core';

export interface Alert {
  title?: string;
  message: string;
  suicideTime?: Date;
}

interface InternalAlert {
  title?: string;
  message: string;
  type: 'success' | 'warn' | 'error' | 'info';
  suicideTime: Date;
}

const DEFAULT_TIME_TO_LIVE = 3;

function getDefaultSuicideTime(): Date {
  const suicideTime = new Date();
  suicideTime.setSeconds(suicideTime.getSeconds() + DEFAULT_TIME_TO_LIVE);

  return suicideTime;
}

@Injectable({
  providedIn: 'root',
})
export class AlertService {
  alerts: InternalAlert[] = [];

  constructor() {
    /*setInterval(() => {
      const now = new Date();
      this.alerts = this.alerts.filter((a) => a.suicideTime > now);
    }, 100);*/
    setInterval(() => {
      const now = Date.now();
      this.alerts = this.alerts.filter((a) => a.suicideTime.getTime() > now);
    }, 500);
  }

  private spawn(alert: InternalAlert) {
    this.alerts.push(alert);
    setTimeout(
      () => document.getElementById('alertHook').scrollIntoView(),
      200
    );
  }

  success(alert: Alert) {
    this.spawn({
      ...alert,
      type: 'success',
      suicideTime: alert.suicideTime ?? getDefaultSuicideTime(),
    });
  }

  warn(alert: Alert) {
    this.spawn({
      ...alert,
      type: 'warn',
      suicideTime: alert.suicideTime ?? getDefaultSuicideTime(),
    });
  }

  error(alert: Alert) {
    this.spawn({
      ...alert,
      type: 'error',
      suicideTime: alert.suicideTime ?? getDefaultSuicideTime(),
    });
  }

  info(alert: Alert) {
    this.spawn({
      ...alert,
      type: 'info',
      suicideTime: alert.suicideTime ?? getDefaultSuicideTime(),
    });
  }
}
