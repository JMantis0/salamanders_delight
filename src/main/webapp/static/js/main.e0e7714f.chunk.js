(this.webpackJsonpsalamander_react=this.webpackJsonpsalamander_react||[]).push([[0],{61:function(e,t,n){},90:function(e,t,n){},91:function(e,t,n){"use strict";n.r(t);var a=n(0),c=n.n(a),o=n(8),i=n.n(o),r=(n(61),n(126)),s=n(10),l=n(6),j=function(){var e=Object(s.f)();return Object(l.jsxs)("div",{children:["This will be the home page",Object(l.jsx)(r.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},h=n(18),d=n(39),b=n(21),u=n(125),p=n(124),O=n(50),g=n.n(O),x=Object(p.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),m=function(){var e=x(),t=Object(a.useState)({empID:"",password:""}),n=Object(b.a)(t,2),c=n[0],o=n[1],i=(Object(s.f)(),function(e){var t=e.target.name,n=e.target.value;console.log("Updated ".concat(t," with value ").concat(n)),o(Object(d.a)(Object(d.a)({},c),{},Object(h.a)({},t,n)))});return Object(l.jsxs)("div",{children:["This will be the login page",Object(l.jsxs)("form",{className:e.root,noValidate:!0,autoComplete:"off",children:[Object(l.jsx)(u.a,{id:"outlined-basic",label:"Employee ID",variant:"outlined",name:"empID",onChange:i}),Object(l.jsx)(u.a,{type:"password",label:"Password",variant:"outlined",name:"password",onChange:i}),Object(l.jsx)(r.a,{color:"primary",variant:"contained",onClick:function(){console.log("Calling Login Servlet with formData: ",c),g.a.post("/api/passwordcheck",c,{headers:{"Content-Type":"application/json"}}).then((function(e){console.log("angus beads"),console.log(e)})).catch((function(e){console.log(e.response)}))},children:"Submit"})]})]})},f=function(){return Object(l.jsx)("div",{children:"This will be the Employee Home Page"})},v=function(){return Object(l.jsx)("div",{children:"This will be the Manager Home page"})},w=(n(90),n(31)),C=function(){return Object(l.jsx)("div",{children:"This will be the header."})};var y=function(){return Object(l.jsxs)(w.a,{children:[Object(l.jsx)(C,{}),Object(l.jsxs)(s.c,{children:[Object(l.jsx)(s.a,{exact:!0,path:"/",children:Object(l.jsx)(j,{})}),Object(l.jsx)(s.a,{exact:!0,path:"/login",children:Object(l.jsx)(m,{})}),Object(l.jsx)(s.a,{exact:!0,path:"/employeehome",children:Object(l.jsx)(f,{})}),Object(l.jsx)(s.a,{exact:!0,path:"/managerhome",children:Object(l.jsx)(v,{})}),Object(l.jsx)(s.a,{exact:!0,path:"/invalidlogin",children:"Invalid username/password combo."})]})]})},T=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,128)).then((function(t){var n=t.getCLS,a=t.getFID,c=t.getFCP,o=t.getLCP,i=t.getTTFB;n(e),a(e),c(e),o(e),i(e)}))};i.a.render(Object(l.jsx)(c.a.StrictMode,{children:Object(l.jsx)(y,{})}),document.getElementById("root")),T()}},[[91,1,2]]]);
//# sourceMappingURL=main.e0e7714f.chunk.js.map