(this.webpackJsonpsalamander_react_redux_typescript=this.webpackJsonpsalamander_react_redux_typescript||[]).push([[0],{102:function(e,t,a){},132:function(e,t,a){"use strict";a.r(t);var n=a(0),c=a.n(n),r=a(11),s=a.n(r),o=(a(102),a(164)),l=a(15),i=a(2),j=function(){var e=Object(l.f)();return Object(i.jsxs)("div",{children:["This will be the home page",Object(i.jsx)(o.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},u=a(181),d=a(182),b=a(169),h=a(183),m=a(168),O=a(50),g=function(){return Object(O.b)()},p=O.c,x=a(23),f=a(9),v=a(14),S=a(58),y={employeeRequestsState:[],loginState:{userID:"",password:"",loginType:""},createRequestState:{justification:"",amount:""},currentUser:{firstName:"",lastName:"",userID:"",password:"",id:{timestamp:null,date:null}},employeesState:[],allReimbursementsState:[]},w=Object(S.b)({name:"salamander",initialState:y,reducers:{setEmployeeRequestsState:function(e,t){e.employeeRequestsState=t.payload},resetEmployeeRequestsState:function(e){e.employeeRequestsState=[]},setRequestFormState:function(e,t){console.log("action",t);var a=t.payload.fieldName,n=t.payload.value;console.log("updating ".concat(a," to ").concat(n)),e.createRequestState=Object(v.a)(Object(v.a)({},e.createRequestState),{},Object(f.a)({},a,n))},setLoginFormState:function(e,t){console.log("action",t);var a=t.payload.fieldName,n=t.payload.value;console.log("updating ".concat(a," to ").concat(n)),e.loginState=Object(v.a)(Object(v.a)({},e.loginState),{},Object(f.a)({},a,n))},resetLoginFormData:function(e){e.loginState.userID="",e.loginState.password="",e.loginState.loginType=""},setCurrentUser:function(e,t){console.log("action",t),console.log("action.payload",t.payload),e.currentUser=Object(v.a)(Object(v.a)({},e.currentUser),t.payload)},resetCurrentUser:function(e){e.currentUser={firstName:"",lastName:"",userID:"",password:"",id:{timestamp:null,date:null}}},setAllReimbursementsState:function(e,t){e.allReimbursementsState=Object(x.a)(t.payload)},resetAllReimbursementsState:function(e){e.allReimbursementsState=[]},setEmployeesState:function(e,t){e.employeesState=Object(x.a)(t.payload)},resetState:function(e){y}}}),N=w.actions,_=N.setEmployeeRequestsState,C=(N.resetEmployeeRequestsState,N.setRequestFormState),R=N.setLoginFormState,q=N.resetLoginFormData,D=N.setCurrentUser,I=(N.resetCurrentUser,N.setAllReimbursementsState),U=(N.resetAllReimbursementsState,N.resetState),k=N.setEmployeesState,F=function(e){return e.salamander},T=w.reducer,A=a(178),B=a(167),L=a(18),E=a.n(L),M=Object(B.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),P=function(){var e=M(),t=p(F),a=g(),n=Object(l.f)(),c=function(e){console.log(e);var t=e.target.name,n=e.target.value;a(R({fieldName:t,value:n}))};return Object(i.jsxs)(h.a,{className:e.root,component:"fieldset",children:[Object(i.jsx)(m.a,{component:"legend",children:"Login"}),Object(i.jsx)(A.a,{autoComplete:"off",type:"text",label:"User ID",variant:"outlined",name:"userID",onChange:c}),Object(i.jsx)(A.a,{autoComplete:"off",type:"password",label:"Password",variant:"outlined",name:"password",onChange:c}),Object(i.jsxs)(d.a,{"aria-label":"gender",name:"loginType",row:!0,value:t.loginState.loginType,onChange:c,children:[Object(i.jsx)(b.a,{value:"employee",control:Object(i.jsx)(u.a,{}),label:"Employee"}),Object(i.jsx)(b.a,{value:"manager",control:Object(i.jsx)(u.a,{}),label:"Manager"})]}),Object(i.jsx)(o.a,{color:"primary",variant:"contained",onClick:function(){console.log("login",t.loginState),console.log("Calling Login Servlet with login object: ",t.loginState),E.a.post("/api/attempt_login",t.loginState,{headers:{"Content-Type":"application/json"}}).then((function(e){var t=e.data;n.push(t)})).catch((function(e){var t=e.response.data;a(q()),n.push(t)}))},children:"Submit"})]})},J=function(){var e=Object(l.f)(),t=g();return Object(i.jsx)("div",{children:Object(i.jsx)(o.a,{onClick:function(a){t(U()),e.push("/")},children:"Log Out"})})},Y=function(){var e=p(F);return Object(i.jsxs)("h1",{children:["Welcome, ",e.currentUser.firstName,".",Object(i.jsx)("span",{children:Object(i.jsx)(J,{})})]})},G=a(3),W=a(19),z=a(171),H=a(175),K=a(174),Q=a(170),V=a(172),X=a(173),Z=a(134),$=a(29),ee=a.n($),te=function(){var e=p(F),t=g();Object(n.useMemo)((function(){E.a.get("/api/current_user?userID=".concat(e.loginState.userID,"&loginType=").concat(e.loginState.loginType)).then((function(e){console.log("response",e);var a=e.data;t(D(a))})).catch((function(e){console.log("There was an error: ",e)}))}),[]);var a=function(a){console.log(a);var n=prompt("Submit a new ".concat(a.target.name));if(n){var c={userID:e.currentUser.userID,field:a.target.name,value:n};console.log("data",c),E.a.put("/api/update_emp_field",c).then((function(e){console.log("response",e);var c=Object(f.a)({},a.target.name,n);t(D(c))})).catch((function(e){console.log("Was an error: ",e)}))}};return Object(i.jsxs)("div",{children:["This is where employee information is displayed.",Object(i.jsx)(Q.a,{component:Z.a,children:Object(i.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(i.jsx)(V.a,{children:Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{children:"User ID"}),Object(i.jsxs)(K.a,{align:"right",children:["Last Name",Object(i.jsx)("button",{name:"lastName",onClick:a,children:"Update"})]}),Object(i.jsxs)(K.a,{align:"right",children:["First Name",Object(i.jsx)("button",{name:"firstName",onClick:a,children:"Update"})]}),Object(i.jsxs)(K.a,{align:"right",children:["Password",Object(i.jsx)("button",{name:"password",onClick:a,children:"Update"})]})]})}),Object(i.jsx)(H.a,{children:Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{component:"th",scope:"row",children:e.currentUser.userID}),Object(i.jsx)(K.a,{align:"right",children:e.currentUser.lastName}),Object(i.jsx)(K.a,{align:"right",children:e.currentUser.firstName}),Object(i.jsx)(K.a,{align:"right",children:e.currentUser.password})]})})]})})]})},ae=a(176),ne=a(180),ce=a(177),re=a(135),se=a(179),oe=Object(B.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),le=function(){var e=oe(),t=p(F),a=g(),n=function(e){var t=e.target.name,n=e.target.value;console.log("the value of ".concat(t," is now ").concat(n)),a(C({fieldName:t,value:n}))};return Object(i.jsx)("div",{children:Object(i.jsxs)("form",{className:e.root,children:[Object(i.jsx)(A.a,{autoComplete:"off",type:"text",label:"Justification",variant:"outlined",name:"justification",onChange:n}),Object(i.jsx)(A.a,{autoComplete:"off",type:"number",label:"Amount",variant:"outlined",name:"amount",placeholder:"in USD",onChange:n}),Object(i.jsx)(o.a,{onClick:function(){console.log("salamander.loginState",t.loginState),console.log("calling /create_new_request with data: ",t.createRequestState);var e={requesterID:t.loginState.userID,justification:t.createRequestState.justification,amount:t.createRequestState.amount,resolvedBy:null,status:"Pending"};E.a.post("/api/create_new_request",e).then((function(e){console.log("response.data",e.data),E.a.get("/api/get_requests?userID=".concat(t.loginState.userID)).then((function(e){console.log("response.data",JSON.stringify(e.data)),a(_(e.data))})).catch((function(e){console.log("there was an error: ",e.response)}))})).catch((function(e){console.log("There was an error",e)}))},children:"Submit"})]})})},ie=function(){var e=p(F),t=g();return Object(n.useMemo)((function(){E.a.get("/api/get_requests?userID=".concat(e.loginState.userID)).then((function(e){console.log("response.data",e.data),t(_(e.data))})).catch((function(e){console.log("there was an error: ",e.response)}))}),[]),Object(i.jsx)(c.a.Fragment,{children:Object(i.jsx)(Q.a,{component:Z.a,children:Object(i.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(i.jsx)(V.a,{children:Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{children:"Justification"}),Object(i.jsx)(K.a,{align:"right",children:"Amount"}),Object(i.jsx)(K.a,{align:"right",children:"Status"}),Object(i.jsx)(K.a,{align:"right",children:"Resolved By"})]})}),Object(i.jsx)(H.a,{children:e.employeeRequestsState.map((function(e){return Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{component:"th",scope:"row",children:e.justification}),Object(i.jsx)(K.a,{align:"right",children:e.amount}),Object(i.jsx)(K.a,{align:"right",children:e.status}),Object(i.jsx)(K.a,{align:"right",children:e.resolvedBy?e.resolvedBy:"Unresolved"})]},e.id.timestamp)}))})]})})})};function je(e){var t=e.children,a=e.value,n=e.index,c=Object(G.a)(e,["children","value","index"]);return Object(i.jsx)("div",Object(v.a)(Object(v.a)({role:"tabpanel",hidden:a!==n,id:"simple-tabpanel-".concat(n),"aria-labelledby":"simple-tab-".concat(n)},c),{},{children:a===n&&Object(i.jsx)(se.a,{p:3,children:Object(i.jsx)(re.a,{children:t})})}))}function ue(e){return{id:"simple-tab-".concat(e),"aria-controls":"simple-tabpanel-".concat(e)}}var de=Object(B.a)((function(e){return{root:{flexGrow:1,backgroundColor:e.palette.background.paper}}})),be=function(){var e=de(),t=c.a.useState(0),a=Object(W.a)(t,2),n=a[0],r=a[1];return Object(i.jsxs)("div",{className:e.root,children:[Object(i.jsx)(ae.a,{position:"static",children:Object(i.jsxs)(ne.a,{value:n,onChange:function(e,t){r(t)},"aria-label":"simple tabs example",children:[Object(i.jsx)(ce.a,Object(v.a)({label:"Your Profile"},ue(0))),Object(i.jsx)(ce.a,Object(v.a)({label:"Submit New Request"},ue(1))),Object(i.jsx)(ce.a,Object(v.a)({label:"Your Requests"},ue(2)))]})}),Object(i.jsx)(je,{value:n,index:0,children:Object(i.jsx)(te,{})}),Object(i.jsx)(je,{value:n,index:1,children:Object(i.jsx)(le,{})}),Object(i.jsx)(je,{value:n,index:2,children:Object(i.jsx)(ie,{})})]})},he=function(){return Object(i.jsxs)(c.a.Fragment,{children:[Object(i.jsx)(Y,{}),Object(i.jsx)(be,{})]})},me=function(){var e=p(F),t=g(),a=function(){E.a.get("/api/get_all_reqs").then((function(e){console.log("response",e);var a=e.data;t(I(a))})).catch((function(e){console.log("There was an error: ",e)}))};Object(n.useMemo)((function(){a()}),[]);var r=function(t,n){console.log("event",t);var c="something";"MuiButtonBase-root MuiButton-root MuiButton-text"===t.target.className?(console.log("You clicked on the edge."),c=t.target.name,console.log("resolution: ",c)):"MuiButton-label"===t.target.className&&(console.log("You clicked on the label"),c=t.target.parentNode.name,console.log("resolution: ",c));var r={resolution:c,objectId:n,resolver:"".concat(e.currentUser.firstName," ").concat(e.currentUser.lastName," (").concat(e.currentUser.userID,")")};E.a.put("/api/resolve_request",r).then((function(e){console.log("response",e),a()})).catch((function(e){console.log("There was an error: ",e)}))};return Object(i.jsx)("div",{children:Object(i.jsx)(c.a.Fragment,{children:Object(i.jsx)(Q.a,{component:Z.a,children:Object(i.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(i.jsx)(V.a,{children:Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{children:"Requested By"}),Object(i.jsx)(K.a,{align:"right",children:"Justification"}),Object(i.jsx)(K.a,{align:"right",children:"Amount"}),Object(i.jsx)(K.a,{align:"right",children:"Status"}),Object(i.jsx)(K.a,{align:"right",children:"Resolved By"})]})}),Object(i.jsx)(H.a,{children:e.allReimbursementsState.map((function(e){return Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{component:"th",scope:"row",children:e.requesterID}),Object(i.jsx)(K.a,{align:"right",children:e.justification}),Object(i.jsx)(K.a,{align:"right",children:e.amount}),Object(i.jsx)(K.a,{align:"right",children:"Pending"===e.status?Object(i.jsxs)(c.a.Fragment,{children:[Object(i.jsx)(o.a,{name:"Approved",onClick:function(t){r(t,e.customId)},children:"Approve"}),Object(i.jsxs)(o.a,{name:"Denied",onClick:function(t){r(t,e.customId)},children:[" ","Deny"]})]}):e.status}),Object(i.jsx)(K.a,{align:"right",children:e.resolvedBy?e.resolvedBy:"Unresolved"})]},e.id.timestamp)}))})]})})})})},Oe=function(){var e=p(F),t=g();return Object(n.useMemo)((function(){E.a.get("/api/get_all_employees").then((function(e){console.log("response: ",e);var a=e.data;t(k(a))})).catch((function(e){console.log("There was an error: ",e)}))}),[]),Object(i.jsx)("div",{children:Object(i.jsx)(Q.a,{component:Z.a,children:Object(i.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(i.jsx)(V.a,{children:Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{children:"Employee ID"}),Object(i.jsx)(K.a,{align:"right",children:"First Name"}),Object(i.jsx)(K.a,{align:"right",children:"Last Name"})]})}),Object(i.jsx)(H.a,{children:e.employeesState.map((function(e){return Object(i.jsxs)(X.a,{children:[Object(i.jsx)(K.a,{component:"th",scope:"row",children:e.userID}),Object(i.jsx)(K.a,{align:"right",children:e.firstName}),Object(i.jsx)(K.a,{align:"right",children:e.lastName})]},e.id.timestamp)}))})]})})})};function ge(e){var t=e.children,a=e.value,n=e.index,c=Object(G.a)(e,["children","value","index"]);return Object(i.jsx)("div",Object(v.a)(Object(v.a)({role:"tabpanel",hidden:a!==n,id:"simple-tabpanel-".concat(n),"aria-labelledby":"simple-tab-".concat(n)},c),{},{children:a===n&&Object(i.jsx)(se.a,{p:3,children:Object(i.jsx)(re.a,{children:t})})}))}function pe(e){return{id:"simple-tab-".concat(e),"aria-controls":"simple-tabpanel-".concat(e)}}var xe=Object(B.a)((function(e){return{root:{flexGrow:1,backgroundColor:e.palette.background.paper}}})),fe=function(){var e=xe(),t=c.a.useState(0),a=Object(W.a)(t,2),n=a[0],r=a[1];return Object(i.jsxs)("div",{className:e.root,children:[Object(i.jsx)(ae.a,{position:"static",children:Object(i.jsxs)(ne.a,{value:n,onChange:function(e,t){r(t)},"aria-label":"simple tabs example",children:[Object(i.jsx)(ce.a,Object(v.a)({label:"Your Profile"},pe(0))),Object(i.jsx)(ce.a,Object(v.a)({label:"All Employees"},pe(1))),Object(i.jsx)(ce.a,Object(v.a)({label:"All Reimbursement Requests"},pe(2)))]})}),Object(i.jsx)(ge,{value:n,index:0,children:Object(i.jsx)(te,{})}),Object(i.jsx)(ge,{value:n,index:1,children:Object(i.jsx)(Oe,{})}),Object(i.jsx)(ge,{value:n,index:2,children:Object(i.jsx)(me,{})})]})},ve=function(){return Object(i.jsxs)(c.a.Fragment,{children:[Object(i.jsx)(Y,{}),Object(i.jsx)(fe,{})]})},Se=function(){return Object(i.jsx)("div",{children:"No such user exists"})},ye=function(){return Object(i.jsx)("div",{children:"Invalid Password"})},we=a(47),Ne=function(){return Object(i.jsx)("div",{children:"This will be the header."})};var _e=function(){return Object(i.jsxs)(we.a,{children:[Object(i.jsx)(Ne,{}),Object(i.jsxs)(l.c,{children:[Object(i.jsx)(l.a,{exact:!0,path:"/",children:Object(i.jsx)(j,{})}),Object(i.jsx)(l.a,{exact:!0,path:"/login",children:Object(i.jsx)(P,{})}),Object(i.jsx)(l.a,{exact:!0,path:"/employee_home",children:Object(i.jsx)(he,{})}),Object(i.jsx)(l.a,{exact:!0,path:"/manager_home",children:Object(i.jsx)(ve,{})}),Object(i.jsx)(l.a,{exact:!0,path:"/invalid_password",children:Object(i.jsx)(ye,{})}),Object(i.jsx)(l.a,{exact:!0,path:"/no_such_user",children:Object(i.jsx)(Se,{})})]})]})},Ce=Object(S.a)({reducer:{salamander:T}}),Re=function(e){e&&e instanceof Function&&a.e(3).then(a.bind(null,185)).then((function(t){var a=t.getCLS,n=t.getFID,c=t.getFCP,r=t.getLCP,s=t.getTTFB;a(e),n(e),c(e),r(e),s(e)}))};s.a.render(Object(i.jsx)(c.a.StrictMode,{children:Object(i.jsx)(O.a,{store:Ce,children:Object(i.jsx)(_e,{})})}),document.getElementById("root")),Re()},29:function(e,t,a){e.exports={App:"Salamander_App__2LeMn","App-logo":"Salamander_App-logo__3zLcd",table:"Salamander_table__2Piwo"}}},[[132,1,2]]]);
//# sourceMappingURL=main.280a97cf.chunk.js.map