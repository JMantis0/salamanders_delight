(this.webpackJsonpsalamander_react=this.webpackJsonpsalamander_react||[]).push([[0],{61:function(e,t,n){},90:function(e,t,n){},91:function(e,t,n){"use strict";n.r(t);var c=n(0),a=n.n(c),i=n(8),o=n.n(i),s=(n(61),n(126)),r=n(10),l=n(4),j=function(){var e=Object(r.f)();return Object(l.jsxs)("div",{children:["This will be the home page",Object(l.jsx)(s.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},d=n(18),h=n(39),b=n(21),u=n(125),p=n(124),O=n(50),x=n.n(O),g=Object(p.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),f=function(){var e=g(),t=Object(c.useState)({empID:"",password:""}),n=Object(b.a)(t,2),a=n[0],i=n[1],o=Object(r.f)(),j=function(e){var t=e.target.name,n=e.target.value;console.log("Updated ".concat(t," with value ").concat(n)),i(Object(h.a)(Object(h.a)({},a),{},Object(d.a)({},t,n)))};return Object(l.jsxs)("div",{children:["This will be the login page",Object(l.jsxs)("form",{className:e.root,noValidate:!0,autoComplete:"off",children:[Object(l.jsx)(u.a,{id:"outlined-basic",label:"Employee ID",variant:"outlined",name:"empID",onChange:j}),Object(l.jsx)(u.a,{type:"password",label:"Password",variant:"outlined",name:"password",onChange:j}),Object(l.jsx)(s.a,{color:"primary",variant:"contained",onClick:function(){console.log("Calling Login Servlet with formData: ",a),x.a.post("/api/passwordcheck",a,{headers:{"Content-Type":"application/json"}}).then((function(e){console.log("angus beads"),console.log(e),o.push(e.data)})).catch((function(e){console.log(e.response.data),console.log("update")}))},children:"Submit"})]})]})},m=function(){return Object(l.jsx)("div",{children:"This will be the Employee Home Page"})},v=function(){return Object(l.jsx)("div",{children:"This will be the Manager Home page"})},w=function(){return Object(l.jsx)("div",{children:"No such user exists"})},C=function(){return Object(l.jsx)("div",{children:"Invalid Password"})},y=(n(90),n(31)),T=function(){return Object(l.jsx)("div",{children:"This will be the header."})};var I=function(){return Object(l.jsxs)(y.a,{children:[Object(l.jsx)(T,{}),Object(l.jsxs)(r.c,{children:[Object(l.jsx)(r.a,{exact:!0,path:"/",children:Object(l.jsx)(j,{})}),Object(l.jsx)(r.a,{exact:!0,path:"/login",children:Object(l.jsx)(f,{})}),Object(l.jsx)(r.a,{exact:!0,path:"/employeehome",children:Object(l.jsx)(m,{})}),Object(l.jsx)(r.a,{exact:!0,path:"/managerhome",children:Object(l.jsx)(v,{})}),Object(l.jsx)(r.a,{exact:!0,path:"/invalidpassword",children:Object(l.jsx)(C,{})}),Object(l.jsx)(r.a,{exact:!0,path:"/nosuchuser",children:Object(l.jsx)(w,{})})]})]})},k=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,128)).then((function(t){var n=t.getCLS,c=t.getFID,a=t.getFCP,i=t.getLCP,o=t.getTTFB;n(e),c(e),a(e),i(e),o(e)}))};o.a.render(Object(l.jsx)(a.a.StrictMode,{children:Object(l.jsx)(I,{})}),document.getElementById("root")),k()}},[[91,1,2]]]);
//# sourceMappingURL=main.4e95bc49.chunk.js.map