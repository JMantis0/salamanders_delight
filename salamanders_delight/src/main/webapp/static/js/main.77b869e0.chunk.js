(this.webpackJsonpsalamander_react_redux_typescript=this.webpackJsonpsalamander_react_redux_typescript||[]).push([[0],{106:function(e,t,a){"use strict";a.r(t);var n=a(0),c=a.n(n),r=a(8),o=a.n(r),s=(a(76),a(145)),i=a(12),l=a(2),u=function(){var e=Object(i.f)();return Object(l.jsxs)("div",{children:["This will be the home page",Object(l.jsx)(s.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},j=a(36),d=function(){return Object(j.b)()},h=j.c,p=a(15),b=a(21),m=a(41),g=Object(m.b)({name:"salamander",initialState:{requestsState:[],loginState:{empID:"",password:""},createRequestState:{justification:"",amount:""},currentUser:{firstName:"",lastName:"",empID:"",password:"",id:{timestamp:null,date:null}}},reducers:{updateAllRequests:function(e,t){e.requestsState=t.payload},resetEmployeeRequests:function(e){e.requestsState=[]},setRequestFormState:function(e,t){console.log("action",t);var a=t.payload.fieldName,n=t.payload.value;console.log("updating ".concat(a," to ").concat(n)),e.createRequestState=Object(b.a)(Object(b.a)({},e.createRequestState),{},Object(p.a)({},a,n))},setLoginFormState:function(e,t){console.log("action",t);var a=t.payload.fieldName,n=t.payload.value;console.log("updating ".concat(a," to ").concat(n)),e.loginState=Object(b.a)(Object(b.a)({},e.loginState),{},Object(p.a)({},a,n))},resetLoginFormData:function(e){e.loginState.empID="",e.loginState.password=""},setCurrentUser:function(e,t){console.log("action",t),console.log("action.payload",t.payload),e.currentUser=Object(b.a)(Object(b.a)({},e.currentUser),t.payload)},resetCurrentUser:function(e){e.currentUser={firstName:"",lastName:"",empID:"",password:"",id:{timestamp:null,date:null}}}}}),O=g.actions,f=O.updateAllRequests,x=O.resetEmployeeRequests,v=O.setRequestFormState,S=O.setLoginFormState,w=O.resetLoginFormData,_=O.setCurrentUser,y=O.resetCurrentUser,C=function(e){return e.salamander},q=g.reducer,D=a(144),I=a(136),N=a(19),U=a.n(N),R=Object(I.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),F=function(){var e=R(),t=h(C),a=d(),n=Object(i.f)(),c=function(e){var t=e.target.name,n=e.target.value;a(S({fieldName:t,value:n}))};return Object(l.jsxs)("div",{children:["This will be the login page",Object(l.jsxs)("form",{className:e.root,noValidate:!0,autoComplete:"off",children:[Object(l.jsx)(D.a,{autoComplete:"off",type:"text",label:"Employee ID",variant:"outlined",name:"empID",onChange:c}),Object(l.jsx)(D.a,{autoComplete:"off",type:"password",label:"Password",variant:"outlined",name:"password",onChange:c}),Object(l.jsx)(s.a,{color:"primary",variant:"contained",onClick:function(){console.log("login",t.loginState),console.log("Calling Login Servlet with login object: ",t.loginState),U.a.post("/api/attempt_login",t.loginState,{headers:{"Content-Type":"application/json"}}).then((function(e){var t=e.data;n.push(t)})).catch((function(e){var t=e.response.data;a(w()),n.push(t)}))},children:"Submit"})]})]})},L=function(){var e=Object(i.f)(),t=d();return Object(l.jsx)("div",{children:Object(l.jsx)(s.a,{onClick:function(a){t(w()),t(x()),t(y()),e.push("/")},children:"Log Out"})})},T=Object(I.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),k=function(){var e=T(),t=h(C),a=d(),n=function(e){var t=e.target.name,n=e.target.value;console.log("the value of ".concat(t," is now ").concat(n)),a(v({fieldName:t,value:n}))};return Object(l.jsx)("div",{children:Object(l.jsxs)("form",{className:e.root,children:[Object(l.jsx)(D.a,{autoComplete:"off",type:"text",label:"Justification",variant:"outlined",name:"justification",onChange:n}),Object(l.jsx)(D.a,{autoComplete:"off",type:"number",label:"Amount",variant:"outlined",name:"amount",placeholder:"in USD",onChange:n}),Object(l.jsx)(s.a,{onClick:function(){console.log("salamander.loginState",t.loginState),console.log("calling /create_new_request with data: ",t.createRequestState);var e={requesterID:t.loginState.empID,justification:t.createRequestState.justification,amount:t.createRequestState.amount};U.a.post("/api/create_new_request",e).then((function(e){console.log("response.data",e.data),U.a.get("/api/get_requests?empID=".concat(t.loginState.empID)).then((function(e){console.log("response.data",e.data),a(f(e.data))})).catch((function(e){console.log("there was an error: ",e.response)}))})).catch((function(e){console.log("There was an error",e)}))},children:"Submit"})]})})},A=a(139),P=a(143),E=a(142),M=a(138),J=a(140),W=a(141),B=a(137),z=a(33),H=a.n(z),V=function(){var e=h(C),t=d();return Object(n.useMemo)((function(){U.a.get("/api/get_requests?empID=".concat(e.loginState.empID)).then((function(e){console.log("response.data",e.data),t(f(e.data))})).catch((function(e){console.log("there was an error: ",e.response)}))}),[]),Object(l.jsx)(c.a.Fragment,{children:Object(l.jsx)(M.a,{component:B.a,children:Object(l.jsxs)(A.a,{className:H.a.table,"aria-label":"reimbursement table",children:[Object(l.jsx)(J.a,{children:Object(l.jsxs)(W.a,{children:[Object(l.jsx)(E.a,{children:"Justification"}),Object(l.jsx)(E.a,{align:"right",children:"Amount"}),Object(l.jsx)(E.a,{align:"right",children:"Status"})]})}),Object(l.jsx)(P.a,{children:e.requestsState.map((function(e){return Object(l.jsxs)(W.a,{children:[Object(l.jsx)(E.a,{component:"th",scope:"row",children:e.justification}),Object(l.jsx)(E.a,{align:"right",children:e.amount}),Object(l.jsx)(E.a,{align:"right",children:e.resolved?"Resolved":"Pending"})]},e.id.timestamp)}))})]})})})},G=function(){var e=h(C);return Object(l.jsxs)("h1",{children:["Welcome, ",e.loginState.empID,"."]})},K=function(){var e=h(C),t=d();Object(n.useMemo)((function(){U.a.get("/api/current_user?empID=".concat(e.loginState.empID)).then((function(e){console.log("response",e);var a=e.data;t(_(a))})).catch((function(e){console.log("There was an error: ",e)}))}),[]);var a=function(a){console.log(a);var n=prompt("Submit a new ".concat(a.target.name));if(n){var c={empID:e.currentUser.empID,field:a.target.name,value:n};console.log("data",c),U.a.put("/api/update_emp_field",c).then((function(e){console.log("response",e);var c=Object(p.a)({},a.target.name,n);t(_(c))})).catch((function(e){console.log("Was an error: ",e)}))}};return Object(l.jsxs)("div",{children:["This is where employee information is displayed.",Object(l.jsx)(M.a,{component:B.a,children:Object(l.jsxs)(A.a,{className:H.a.table,"aria-label":"reimbursement table",children:[Object(l.jsx)(J.a,{children:Object(l.jsxs)(W.a,{children:[Object(l.jsx)(E.a,{children:"Employee ID"}),Object(l.jsxs)(E.a,{align:"right",children:["Last Name",Object(l.jsx)("button",{name:"lastName",onClick:a,children:"Update"})]}),Object(l.jsxs)(E.a,{align:"right",children:["First Name",Object(l.jsx)("button",{name:"firstName",onClick:a,children:"Update"})]}),Object(l.jsxs)(E.a,{align:"right",children:["Password",Object(l.jsx)("button",{name:"password",onClick:a,children:"Update"})]})]})}),Object(l.jsx)(P.a,{children:Object(l.jsxs)(W.a,{children:[Object(l.jsx)(E.a,{component:"th",scope:"row",children:e.currentUser.empID}),Object(l.jsx)(E.a,{align:"right",children:e.currentUser.lastName}),Object(l.jsx)(E.a,{align:"right",children:e.currentUser.firstName}),Object(l.jsx)(E.a,{align:"right",children:e.currentUser.password})]})})]})})]})},Q=function(){return Object(l.jsxs)("div",{children:[Object(l.jsx)(G,{}),Object(l.jsx)(L,{}),Object(l.jsx)(k,{}),"What does a reimbursement request require?",Object(l.jsx)(V,{}),Object(l.jsx)(K,{})]})},X=function(){return Object(l.jsx)("div",{children:"This will be the Manager Home page"})},Y=function(){return Object(l.jsx)("div",{children:"No such user exists"})},Z=function(){return Object(l.jsx)("div",{children:"Invalid Password"})},$=a(32),ee=function(){return Object(l.jsx)("div",{children:"This will be the header."})};var te=function(){return Object(l.jsxs)($.a,{children:[Object(l.jsx)(ee,{}),Object(l.jsxs)(i.c,{children:[Object(l.jsx)(i.a,{exact:!0,path:"/",children:Object(l.jsx)(u,{})}),Object(l.jsx)(i.a,{exact:!0,path:"/login",children:Object(l.jsx)(F,{})}),Object(l.jsx)(i.a,{exact:!0,path:"/employee_home",children:Object(l.jsx)(Q,{})}),Object(l.jsx)(i.a,{exact:!0,path:"/manager_home",children:Object(l.jsx)(X,{})}),Object(l.jsx)(i.a,{exact:!0,path:"/invalid_password",children:Object(l.jsx)(Z,{})}),Object(l.jsx)(i.a,{exact:!0,path:"/no_such_user",children:Object(l.jsx)(Y,{})})]})]})},ae=Object(m.a)({reducer:{salamander:q}}),ne=function(e){e&&e instanceof Function&&a.e(3).then(a.bind(null,147)).then((function(t){var a=t.getCLS,n=t.getFID,c=t.getFCP,r=t.getLCP,o=t.getTTFB;a(e),n(e),c(e),r(e),o(e)}))};o.a.render(Object(l.jsx)(c.a.StrictMode,{children:Object(l.jsx)(j.a,{store:ae,children:Object(l.jsx)(te,{})})}),document.getElementById("root")),ne()},33:function(e,t,a){e.exports={App:"Salamander_App__2LeMn","App-logo":"Salamander_App-logo__3zLcd",table:"Salamander_table__2Piwo"}},76:function(e,t,a){}},[[106,1,2]]]);
//# sourceMappingURL=main.77b869e0.chunk.js.map