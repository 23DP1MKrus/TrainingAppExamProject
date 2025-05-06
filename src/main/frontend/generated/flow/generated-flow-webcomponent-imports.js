import { injectGlobalWebcomponentCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/styles/style.css?inline';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/password-field/theme/lumo/vaadin-password-field.js';
import '@vaadin/email-field/theme/lumo/vaadin-email-field.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/disableOnClickFunctions.js';
import '@vaadin/notification/theme/lumo/vaadin-notification.js';
import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';
import 'Frontend/generated/jar-resources/ReactRouterOutletElement.tsx';

injectGlobalCss($cssFromFile_0.toString(), 'CSSImport end', document);
injectGlobalWebcomponentCss($cssFromFile_0.toString());

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '8104296f1008cd8bd2ad68fb9ceff9ae6d99d276e78c17d8ad119dbfb8be592d') {
    pending.push(import('./chunks/chunk-c3387d4ccb0ecdf278be7171e604233ed3717d9ddef95e73edbe6729e18ae4b5.js'));
  }
  if (key === '9c5f4e451365ac895650364b99bb3edbfa7c2da92e50b1e40f0ce7b059dccb14') {
    pending.push(import('./chunks/chunk-9c276622709906aae43ada0271b184f3eee82147156d73dced974c1a661cb934.js'));
  }
  if (key === '7e12f3820c791033d726fcecf683ac61199a0b05a599193d92cc576c1b57cf3f') {
    pending.push(import('./chunks/chunk-135b615ddb284c1e77cf8e1cca70b768afd0fb2e692d23ea5119bfd563269c44.js'));
  }
  if (key === 'a41a03205acdc36b58493075313be6c855852027aab23f6671e4ba83dcb68098') {
    pending.push(import('./chunks/chunk-135b615ddb284c1e77cf8e1cca70b768afd0fb2e692d23ea5119bfd563269c44.js'));
  }
  if (key === '284b700bc91a534619be095568964bb6d374895ce5936efbc5d97638c545d3ef') {
    pending.push(import('./chunks/chunk-0f2088299dbb4c7b4382acada727513bceb1e61a6ae0e3281fc49f037f18dde6.js'));
  }
  if (key === 'b542ff1e2d6cf3a1aac99ed76514c00e3e187de1636f30802559f18037f3d07c') {
    pending.push(import('./chunks/chunk-135b615ddb284c1e77cf8e1cca70b768afd0fb2e692d23ea5119bfd563269c44.js'));
  }
  if (key === '629f00c6732f3f017c7f9c644717a7a4029d78bd722941f026f0530b885cda6f') {
    pending.push(import('./chunks/chunk-135b615ddb284c1e77cf8e1cca70b768afd0fb2e692d23ea5119bfd563269c44.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}