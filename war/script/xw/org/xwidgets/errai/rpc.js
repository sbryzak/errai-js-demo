package("org.xwidgets.errai");

org.xwidgets.errai.Rpc = function() {
  xw.NonVisual.call(this);
  this._className = "org.xwidgets.errai.Rpc";
  this.registerProperty("service");  
};

org.xwidgets.errai.Rpc.prototype = new xw.NonVisual();

org.xwidgets.errai.Rpc.prototype.open = function() {
  if (!xw.Sys.isDefined(errai)) {
    var that = this;
    var o = {fire: function() { that.init(); }};
    xw.Event.registerObserver("erraiOnLoad", o);
  } else {
    this.init();
  }
};

org.xwidgets.errai.Rpc.prototype.init = function() {
  this.bus = new errai.MsgBus();
};
    
org.xwidgets.errai.Rpc.prototype.invoke = function(value) {
{
  var parms = {};
  parms["^EncodedType"] = "[Ljava.lang.Object;";
  parms["^ObjectID"] = "1";
  parms["^Value"] = [ value ];
  
  var payload = {CommandType : "sayHello:java.lang.String:", 
    MethodParms: parms
//    ReplyTo:
//    ErrorTo:
    }};
  
  this.bus.send(this.service, payload);
  
  /*
  "org.jboss.xwidgetserrai.client.shared.HelloService:RPC", {});
    "ToSubject": ,
    "CommandType": "sayHello:java.lang.String:",
    "MethodParms": {
        "^EncodedType": "[Ljava.lang.Object;",
        "^ObjectID": "1",
        "^Value": [
            "foo"
        ]
    },
    "ReplyTo": "org.jboss.xwidgetserrai.client.shared.HelloService:RPC.sayHello:java.lang.String::RespondTo:2",
    "ErrorTo": "org.jboss.xwidgetserrai.client.shared.HelloService:RPC.sayHello:java.lang.String::Errors:2"
    }*/
};

org.xwidgets.errai.Rpc.prototype.toString = function() {
  return "org.xwidgets.errai.Rpc[" + this.service + "]";
};


