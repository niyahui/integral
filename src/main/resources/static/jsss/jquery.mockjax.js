/*
 * MockJax - jQuery Plugin to Mock Ajax requests
 *
 * Version:  1.5.0pre
 * Released:
 * Home:   http://github.com/appendto/jquery-mockjax
 * Author:   Jonathan Sharp (http://jdsharp.com)
 * License:  MIT,GPL
 *
 * Copyright (c) 2011 appendTo LLC.
 * Dual licensed under the MIT or GPL licenses.
 * http://appendto.com/open-source-licenses
 */
(function(P){var L=P.ajax,H=[],Q=/=\?(&|$)/,D=(new Date()).getTime();function J(V){if(window["DOMParser"]==undefined&&window.ActiveXObject){DOMParser=function(){};DOMParser.prototype.parseFromString=function(Y){var Z=new ActiveXObject("Microsoft.XMLDOM");Z.async="false";Z.loadXML(Y);return Z}}try{var W=(new DOMParser()).parseFromString(V,"text/xml");if(P.isXMLDoc(W)){var X=P("parsererror",W);if(X.length==1){throw ("Error: "+P(W).text())}}else{throw ("Unable to parse XML")}}catch(T){var U=(T.name==undefined?T:T.name+": "+T.message);P(document).trigger("xmlParseError",[U]);return undefined}return W}function R(U,T,V){(U.context?jQuery(U.context):jQuery.event).trigger(T,V)}function O(T,U){var V=false;if(typeof U==="string"){return P.isFunction(T.test)?T.test(U):T==U}P.each(T,function(X,W){if(U[X]===undefined){V=false;return V}else{V=true;if(typeof U[X]=="object"){return O(T[X],U[X])}else{if(P.isFunction(T[X].test)){V=T[X].test(U[X])}else{V=(T[X]==U[X])}return V}}});return V}function F(V,T){if(P.isFunction(V)){return V(T)}if(P.isFunction(V.url.test)){if(!V.url.test(T.url)){return null}}else{var U=V.url.indexOf("*");if(V.url!==T.url&&U===-1||!new RegExp(V.url.replace(/[-[\]{}()+?.,\\^$|#\s]/g,"\\$&").replace("*",".+")).test(T.url)){return null}}if(V.data&&T.data){if(!O(V.data,T.data)){return null}}if(V&&V.type&&V.type.toLowerCase()!=T.type.toLowerCase()){return null}return V}function S(T,V){var U=P.extend({},P.mockjaxSettings,T);if(U.log&&P.isFunction(U.log)){U.log("MOCK "+V.type.toUpperCase()+": "+V.url,P.extend({},V))}}function B(T,V,U){var W=(function(X){return function(){return(function(){this.status=T.status;this.statusText=T.statusText;this.readyState=4;if(P.isFunction(T.response)){T.response(U)}if(V.dataType=="json"&&(typeof T.responseText=="object")){this.responseText=JSON.stringify(T.responseText)}else{if(V.dataType=="xml"){if(typeof T.responseXML=="string"){this.responseXML=J(T.responseXML)}else{this.responseXML=T.responseXML}}else{this.responseText=T.responseText}}if(typeof T.status=="number"||typeof T.status=="string"){this.status=T.status}if(typeof T.statusText==="string"){this.statusText=T.statusText}if(P.isFunction(this.onreadystatechange)){if(T.isTimeout){this.status=-1}this.onreadystatechange(T.isTimeout?"timeout":undefined)}else{if(T.isTimeout){this.status=-1}}}).apply(X)}})(this);if(T.proxy){L({global:false,url:T.proxy,type:T.proxyType,data:T.data,dataType:V.dataType==="script"?"text/plain":V.dataType,complete:function(X,Y){T.responseXML=X.responseXML;T.responseText=X.responseText;T.status=X.status;T.statusText=X.statusText;this.responseTimer=setTimeout(W,T.responseTime||0)}})}else{if(V.async===false){W()}else{this.responseTimer=setTimeout(W,T.responseTime||50)}}}function I(T,V,U,W){T=P.extend({},P.mockjaxSettings,T);if(typeof T.headers==="undefined"){T.headers={}}if(T.contentType){T.headers["content-type"]=T.contentType}return{status:T.status,statusText:T.statusText,readyState:1,open:function(){},send:function(){W.fired=true;B.call(this,T,V,U)},abort:function(){clearTimeout(this.responseTimer)},setRequestHeader:function(X,Y){T.headers[X]=Y},getResponseHeader:function(X){if(T.headers&&T.headers[X]){return T.headers[X]}else{if(X.toLowerCase()=="last-modified"){return T.lastModified||(new Date()).toString()}else{if(X.toLowerCase()=="etag"){return T.etag||""}else{if(X.toLowerCase()=="content-type"){return T.contentType||"text/plain"}}}}},getAllResponseHeaders:function(){var X="";P.each(T.headers,function(Z,Y){X+=Z+": "+Y+"\n"});return X}}}function C(U,V,Y){K(U);U.dataType="json";if(U.data&&Q.test(U.data)||Q.test(U.url)){N(U,V);var W=/^(\w+:)?\/\/([^\/?#]+)/,T=W.exec(U.url),Z=T&&(T[1]&&T[1]!==location.protocol||T[2]!==location.host);U.dataType="script";if(U.type.toUpperCase()==="GET"&&Z){var X=E(U,V,Y);if(X){return X}else{return true}}}return null}function K(T){if(T.type.toUpperCase()==="GET"){if(!Q.test(T.url)){T.url+=(/\?/.test(T.url)?"&":"?")+(T.jsonp||"callback")+"=?"}}else{if(!T.data||!Q.test(T.data)){T.data=(T.data?T.data+"&":"")+(T.jsonp||"callback")+"=?"}}}function E(T,U,W){var X=W&&W.context||T,V=null;if(U.response&&P.isFunction(U.response)){U.response(W)}else{if(typeof U.responseText==="object"){P.globalEval("("+JSON.stringify(U.responseText)+")")}else{P.globalEval("("+U.responseText+")")}}M(T,U);A(T,U);if(jQuery.Deferred){V=new jQuery.Deferred();if(typeof U.responseText=="object"){V.resolve(U.responseText)}else{V.resolve(jQuery.parseJSON(U.responseText))}}return V}function N(T,U){jsonp=T.jsonpCallback||("jsonp"+D++);if(T.data){T.data=(T.data+"").replace(Q,"="+jsonp+"$1")}T.url=T.url.replace(Q,"="+jsonp+"$1");window[jsonp]=window[jsonp]||function(V){data=V;M(T,U);A(T,U);window[jsonp]=undefined;try{delete window[jsonp]}catch(W){}if(head){head.removeChild(script)}}}function M(T,U){if(T.success){T.success.call(callbackContext,(U.response?U.response.toString():U.responseText||""),status,{})}if(T.global){R(T,"ajaxSuccess",[{},T])}}function A(T,U){if(T.complete){T.complete.call(callbackContext,{},status)}if(T.global){R("ajaxComplete",[{},T])}if(T.global&&!--jQuery.active){jQuery.event.trigger("ajaxStop")}}function G(U,X){var W,T,V;if(typeof U==="object"){X=U;U=undefined}else{X.url=U}T=jQuery.extend(true,{},jQuery.ajaxSettings,X);for(var Y=0;Y<H.length;Y++){if(!H[Y]){continue}V=F(H[Y],T);if(!V){continue}S(V,T);if(T.dataType==="jsonp"){if((W=C(T,V,X))){return W}}V.cache=T.cache;V.timeout=T.timeout;V.global=T.global;(function(Z,b,a,c){W=L.call(P,P.extend(true,{},a,{xhr:function(){return I(Z,b,a,c)}}))})(V,T,X,H[Y]);return W}return L.apply(P,[X])}P.extend({ajax:G});P.mockjaxSettings={log:function(T){window["console"]&&window.console.log&&window.console.log(T)},status:200,statusText:"OK",responseTime:500,isTimeout:false,contentType:"text/plain",response:"",responseText:"",responseXML:"",proxy:"",proxyType:"GET",lastModified:null,etag:"",headers:{etag:"IJF@H#@923uf8023hFO@I#H#","content-type":"text/plain"}};P.mockjax=function(U){var T=H.length;H[T]=U;return T};P.mockjaxClear=function(T){if(arguments.length==1){H[T]=null}else{H=[]}};P.mockjax.handler=function(T){if(arguments.length==1){return H[T]}}})(jQuery);