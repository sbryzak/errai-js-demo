package("org.xwidgets.core");

org.xwidgets.core.Label = function() {
  xw.Visual.call(this);
  this._className = "org.xwidgets.core.Label"; 
  this.registerProperty("value", "");
  this.registerProperty("styleClass", "");
  this.control = null;
};

org.xwidgets.core.Label.prototype = new xw.Visual();
  
org.xwidgets.core.Label.prototype.render = function(container) {
  if (this.control == null) {
    var s = document.createElement("label");
    this.control = document.createTextNode(this.value);
    s.className = this.styleClass;
    s.appendChild(this.control);
    container.appendChild(s);
  }       
};
  
org.xwidgets.core.Label.prototype.setValue = function(value) {
  this.value = value;
  if (this.control) this.control.data = value;
};

org.xwidgets.core.Label.prototype.toString = function() {
  return "org.xwidgets.core.Label[" + this.id + "]";
};
