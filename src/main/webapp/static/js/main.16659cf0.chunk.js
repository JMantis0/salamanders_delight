(this.webpackJsonpsalamander_react=this.webpackJsonpsalamander_react||[]).push([[0],{61:function(e,t,n){},90:function(e,t,n){},91:function(e,t,n){"use strict";n.r(t);var a=n(0),c=n.n(a),o=n(8),i=n.n(o),r=(n(61),n(126)),l=n(10),s=n(6),j=function(){var e=Object(l.f)();return Object(s.jsxs)("div",{children:["This will be the home page",Object(s.jsx)(r.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},h=n(18),d=n(39),b=n(21),u=n(125),p=n(124),g=n(50),O=n.n(g),x=Object(p.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),m=function(){var e=x(),t=Object(a.useState)({empID:"",password:""}),n=Object(b.a)(t,2),c=n[0],o=n[1],i=function(e){var t=e.target.name,n=e.target.value;console.log("Updated ".concat(t," with value ").concat(n)),o(Object(d.a)(Object(d.a)({},c),{},Object(h.a)({},t,n)))};return Object(s.jsxs)("div",{children:["This will be the login page",Object(s.jsxs)("form",{className:e.root,noValidate:!0,autoComplete:"off",children:[Object(s.jsx)(u.a,{id:"outlined-basic",label:"Employee ID",variant:"outlined",name:"empID",onChange:i}),Object(s.jsx)(u.a,{type:"password",label:"Password",variant:"outlined",name:"password",onChange:i}),Object(s.jsx)(r.a,{color:"primary",variant:"contained",onClick:function(){console.log("Calling Login Servlet with formData: ",c),O.a.post("/api/passwordcheck",c,{headers:{"Content-Type":"application/json"}}).then((function(e){console.log("response: ",e),console.log("deee")})).catch((function(e){console.log("There was an error calling Login Servlet: ",e),console.log(e),console.log("updated")}))},children:"Submit"})]})]})},f=function(){return Object(s.jsx)("div",{children:"This will be the Employee Home Page"})},v=function(){return Object(s.jsx)("div",{children:"This will be the Manager Home page"})},w=(n(90),n(36)),C=function(){return Object(s.jsx)("div",{children:"This will be the header."})};var T=function(){return Object(s.jsxs)(w.a,{children:[Object(s.jsx)(C,{}),Object(s.jsxs)(l.c,{children:[Object(s.jsx)(l.a,{exact:!0,path:"/",children:Object(s.jsx)(j,{})}),Object(s.jsx)(l.a,{exact:!0,path:"/login",children:Object(s.jsx)(m,{})}),Object(s.jsx)(l.a,{exact:!0,path:"/employeehome",children:Object(s.jsx)(f,{})}),Object(s.jsx)(l.a,{exact:!0,path:"/managerhome",children:Object(s.jsx)(v,{})})]})]})},y=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,128)).then((function(t){var n=t.getCLS,a=t.getFID,c=t.getFCP,o=t.getLCP,i=t.getTTFB;n(e),a(e),c(e),o(e),i(e)}))};i.a.render(Object(s.jsx)(c.a.StrictMode,{children:Object(s.jsx)(T,{})}),document.getElementById("root")),y()}},[[91,1,2]]]);
//# sourceMappingURL=main.16659cf0.chunk.js.map