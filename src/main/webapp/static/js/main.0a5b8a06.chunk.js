(this.webpackJsonpsalamander_react_redux_typescript=this.webpackJsonpsalamander_react_redux_typescript||[]).push([[0],{61:function(e,t,n){},90:function(e,t,n){},91:function(e,t,n){"use strict";n.r(t);var a=n(0),c=n.n(a),i=n(8),r=n.n(i),o=(n(61),n(18)),s=n(37),l=n(21),j=n(126),h=n(10),d=n(4),u=function(){var e=Object(h.f)();return Object(d.jsxs)("div",{children:["This will be the home page",Object(d.jsx)(j.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},b=n(125),p=n(124),x=n(50),O=n.n(x),m=Object(p.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),f=function(e){var t=e.formData,n=e.updateFormData,a=m(),c=Object(h.f)();return Object(d.jsxs)("div",{children:["This will be the login page",Object(d.jsxs)("form",{className:a.root,noValidate:!0,autoComplete:"off",children:[Object(d.jsx)(b.a,{autoComplete:"off",type:"text",label:"Employee ID",variant:"outlined",name:"empID",onChange:n}),Object(d.jsx)(b.a,{autoComplete:"off",type:"password",label:"Password",variant:"outlined",name:"password",onChange:n}),Object(d.jsx)(j.a,{color:"primary",variant:"contained",onClick:function(){console.log("Calling Login Servlet with formData: ",t),O.a.post("/api/attempt_login",t,{headers:{"Content-Type":"application/json"}}).then((function(e){var t=e.data;c.push(t)})).catch((function(e){var t=e.response.data;c.push(t)}))},children:"Submit"})]})]})},g=function(){return Object(d.jsx)("div",{children:"This will be the Employee Home Page"})},v=function(){return Object(d.jsx)("div",{children:"This will be the Manager Home page"})},w=function(){return Object(d.jsx)("div",{children:"No such user exists"})},C=function(){return Object(d.jsx)("div",{children:"Invalid Password"})},_=(n(90),n(31)),y=function(){return Object(d.jsx)("div",{children:"This will be the header."})};var D=function(){var e=Object(a.useState)({empID:"",password:""}),t=Object(l.a)(e,2),n=t[0],c=t[1];return Object(d.jsxs)(_.a,{children:[Object(d.jsx)(y,{}),Object(d.jsxs)(h.c,{children:[Object(d.jsx)(h.a,{exact:!0,path:"/",children:Object(d.jsx)(u,{})}),Object(d.jsx)(h.a,{exact:!0,path:"/login",children:Object(d.jsx)(f,{formData:n,updateFormData:function(e){var t=e.target.name,a=e.target.value;console.log("Updated ".concat(t," with value ").concat(a)),c(Object(s.a)(Object(s.a)({},n),{},Object(o.a)({},t,a)))}})}),Object(d.jsx)(h.a,{exact:!0,path:"/employee_home",children:Object(d.jsx)(g,{})}),Object(d.jsx)(h.a,{exact:!0,path:"/manager_home",children:Object(d.jsx)(v,{})}),Object(d.jsx)(h.a,{exact:!0,path:"/invalid_password",children:Object(d.jsx)(C,{})}),Object(d.jsx)(h.a,{exact:!0,path:"/no_such_user",children:Object(d.jsx)(w,{})})]})]})},T=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,128)).then((function(t){var n=t.getCLS,a=t.getFID,c=t.getFCP,i=t.getLCP,r=t.getTTFB;n(e),a(e),c(e),i(e),r(e)}))};r.a.render(Object(d.jsx)(c.a.StrictMode,{children:Object(d.jsx)(D,{})}),document.getElementById("root")),T()}},[[91,1,2]]]);
//# sourceMappingURL=main.0a5b8a06.chunk.js.map