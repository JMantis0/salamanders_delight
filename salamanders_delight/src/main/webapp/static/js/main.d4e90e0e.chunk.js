(this.webpackJsonpsalamander_react_redux_typescript=this.webpackJsonpsalamander_react_redux_typescript||[]).push([[0],{102:function(e,t,a){},132:function(e,t,a){"use strict";a.r(t);var n=a(0),c=a.n(n),r=a(11),s=a.n(r),i=(a(102),a(164)),o=a(15),l=a(2),j=function(){var e=Object(o.f)();return Object(l.jsxs)("div",{children:["This will be the home page",Object(l.jsx)(i.a,{color:"primary",variant:"contained",onClick:function(t){e.push("/login")},children:"Enter"})]})},u=a(181),d=a(182),b=a(169),h=a(183),m=a(168),O=a(50),p=function(){return Object(O.b)()},g=O.c,x=a(23),f=a(9),v=a(14),S=a(58),y={employeeRequestsState:[],loginState:{userID:"",password:"",loginType:""},createRequestState:{justification:"",amount:""},currentUser:{firstName:"",lastName:"",userID:"",password:"",id:{timestamp:null,date:null}},employeesState:[],allReimbursementsState:[]},w=Object(S.b)({name:"salamander",initialState:y,reducers:{setEmployeeRequestsState:function(e,t){e.employeeRequestsState=t.payload},resetEmployeeRequestsState:function(e){e.employeeRequestsState=[]},setRequestFormState:function(e,t){console.log("action",t);var a=t.payload.fieldName,n=t.payload.value;console.log("updating ".concat(a," to ").concat(n)),e.createRequestState=Object(v.a)(Object(v.a)({},e.createRequestState),{},Object(f.a)({},a,n))},setLoginFormState:function(e,t){console.log("action",t);var a=t.payload.fieldName,n=t.payload.value;console.log("updating ".concat(a," to ").concat(n)),e.loginState=Object(v.a)(Object(v.a)({},e.loginState),{},Object(f.a)({},a,n))},resetLoginFormData:function(e){e.loginState.userID="",e.loginState.password="",e.loginState.loginType=""},setCurrentUser:function(e,t){console.log("action",t),console.log("action.payload",t.payload),e.currentUser=Object(v.a)(Object(v.a)({},e.currentUser),t.payload)},resetCurrentUser:function(e){e.currentUser={firstName:"",lastName:"",userID:"",password:"",id:{timestamp:null,date:null}}},setAllReimbursementsState:function(e,t){e.allReimbursementsState=Object(x.a)(t.payload)},resetAllReimbursementsState:function(e){e.allReimbursementsState=[]},setEmployeesState:function(e,t){e.employeesState=Object(x.a)(t.payload)},resetState:function(e){y}}}),_=w.actions,N=_.setEmployeeRequestsState,C=(_.resetEmployeeRequestsState,_.setRequestFormState),R=_.setLoginFormState,q=_.resetLoginFormData,D=_.setCurrentUser,I=(_.resetCurrentUser,_.setAllReimbursementsState),U=(_.resetAllReimbursementsState,_.resetState),F=_.setEmployeesState,T=function(e){return e.salamander},k=w.reducer,A=a(178),L=a(167),E=a(18),B=a.n(E),P=Object(L.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),M=function(){var e=P(),t=g(T),a=p(),n=Object(o.f)(),c=function(e){console.log(e);var t=e.target.name,n=e.target.value;a(R({fieldName:t,value:n}))};return Object(l.jsxs)(h.a,{className:e.root,component:"fieldset",children:[Object(l.jsx)(m.a,{component:"legend",children:"Login"}),Object(l.jsx)(A.a,{autoComplete:"off",type:"text",label:"User ID",variant:"outlined",name:"userID",onChange:c}),Object(l.jsx)(A.a,{autoComplete:"off",type:"password",label:"Password",variant:"outlined",name:"password",onChange:c}),Object(l.jsxs)(d.a,{"aria-label":"gender",name:"loginType",row:!0,value:t.loginState.loginType,onChange:c,children:[Object(l.jsx)(b.a,{value:"employee",control:Object(l.jsx)(u.a,{}),label:"Employee"}),Object(l.jsx)(b.a,{value:"manager",control:Object(l.jsx)(u.a,{}),label:"Manager"})]}),Object(l.jsx)(i.a,{color:"primary",variant:"contained",onClick:function(){console.log("login",t.loginState),console.log("Calling Login Servlet with login object: ",t.loginState),B.a.post("/api/attempt_login",t.loginState,{headers:{"Content-Type":"application/json"}}).then((function(e){var t=e.data;n.push(t)})).catch((function(e){var t=e.response.data;a(q()),n.push(t)}))},children:"Submit"})]})},J=function(){var e=Object(o.f)(),t=p();return Object(l.jsx)("div",{children:Object(l.jsx)(i.a,{onClick:function(a){t(U()),e.push("/")},children:"Log Out"})})},Y=function(){var e=g(T);return Object(l.jsxs)("h1",{children:["Welcome, ",e.currentUser.firstName,".",Object(l.jsx)(J,{})]})},G=a(3),W=a(19),z=a(171),H=a(175),K=a(174),Q=a(170),V=a(172),X=a(173),Z=a(134),$=a(29),ee=a.n($),te=function(){var e=g(T),t=p();Object(n.useMemo)((function(){B.a.get("/api/current_user?userID=".concat(e.loginState.userID,"&loginType=").concat(e.loginState.loginType)).then((function(e){console.log("response",e);var a=e.data;t(D(a))})).catch((function(e){console.log("There was an error: ",e)}))}),[]);var a=function(a){console.log(a);var n=prompt("Submit a new ".concat(a.target.name));if(n){var c={userID:e.currentUser.userID,field:a.target.name,value:n};console.log("data",c),B.a.put("/api/update_emp_field",c).then((function(e){console.log("response",e);var c=Object(f.a)({},a.target.name,n);t(D(c))})).catch((function(e){console.log("Was an error: ",e)}))}};return Object(l.jsxs)("div",{children:["This is where employee information is displayed.",Object(l.jsx)(Q.a,{component:Z.a,children:Object(l.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(l.jsx)(V.a,{children:Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{children:"User ID"}),Object(l.jsxs)(K.a,{align:"right",children:["Last Name",Object(l.jsx)("button",{name:"lastName",onClick:a,children:"Update"})]}),Object(l.jsxs)(K.a,{align:"right",children:["First Name",Object(l.jsx)("button",{name:"firstName",onClick:a,children:"Update"})]}),Object(l.jsxs)(K.a,{align:"right",children:["Password",Object(l.jsx)("button",{name:"password",onClick:a,children:"Update"})]})]})}),Object(l.jsx)(H.a,{children:Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{component:"th",scope:"row",children:e.currentUser.userID}),Object(l.jsx)(K.a,{align:"right",children:e.currentUser.lastName}),Object(l.jsx)(K.a,{align:"right",children:e.currentUser.firstName}),Object(l.jsx)(K.a,{align:"right",children:e.currentUser.password})]})})]})})]})},ae=a(176),ne=a(180),ce=a(177),re=a(135),se=a(179),ie=Object(L.a)((function(e){return{root:{"& > *":{margin:e.spacing(1),width:"25ch"}}}})),oe=function(){var e=ie(),t=g(T),a=p(),n=function(e){var t=e.target.name,n=e.target.value;console.log("the value of ".concat(t," is now ").concat(n)),a(C({fieldName:t,value:n}))};return Object(l.jsx)("div",{children:Object(l.jsxs)("form",{className:e.root,children:[Object(l.jsx)(A.a,{autoComplete:"off",type:"text",label:"Justification",variant:"outlined",name:"justification",onChange:n}),Object(l.jsx)(A.a,{autoComplete:"off",type:"number",label:"Amount",variant:"outlined",name:"amount",placeholder:"in USD",onChange:n}),Object(l.jsx)(i.a,{onClick:function(){console.log("salamander.loginState",t.loginState),console.log("calling /create_new_request with data: ",t.createRequestState);var e={requesterID:t.loginState.userID,justification:t.createRequestState.justification,amount:t.createRequestState.amount,resolvedBy:null,status:"Pending"};B.a.post("/api/create_new_request",e).then((function(e){console.log("response.data",e.data),B.a.get("/api/get_requests?userID=".concat(t.loginState.userID)).then((function(e){console.log("response.data",JSON.stringify(e.data)),a(N(e.data)),a(C({justification:"",amount:""}))})).catch((function(e){console.log("there was an error: ",e.response)}))})).catch((function(e){console.log("There was an error",e)}))},children:"Submit"})]})})},le=function(){var e=g(T),t=p();return Object(n.useMemo)((function(){B.a.get("/api/get_requests?userID=".concat(e.loginState.userID)).then((function(e){console.log("response.data",e.data),t(N(e.data))})).catch((function(e){console.log("there was an error: ",e.response)}))}),[]),Object(l.jsx)(c.a.Fragment,{children:Object(l.jsx)(Q.a,{component:Z.a,children:Object(l.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(l.jsx)(V.a,{children:Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{children:"Justification"}),Object(l.jsx)(K.a,{align:"right",children:"Amount"}),Object(l.jsx)(K.a,{align:"right",children:"Status"}),Object(l.jsx)(K.a,{align:"right",children:"Resolved By"})]})}),Object(l.jsx)(H.a,{children:e.employeeRequestsState.map((function(e){return Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{component:"th",scope:"row",children:e.justification}),Object(l.jsx)(K.a,{align:"right",children:e.amount}),Object(l.jsx)(K.a,{align:"right",children:e.status}),Object(l.jsx)(K.a,{align:"right",children:e.resolvedBy?e.resolvedBy:"Unresolved"})]},e.id.timestamp)}))})]})})})};function je(e){var t=e.children,a=e.value,n=e.index,c=Object(G.a)(e,["children","value","index"]);return Object(l.jsx)("div",Object(v.a)(Object(v.a)({role:"tabpanel",hidden:a!==n,id:"simple-tabpanel-".concat(n),"aria-labelledby":"simple-tab-".concat(n)},c),{},{children:a===n&&Object(l.jsx)(se.a,{p:3,children:Object(l.jsx)(re.a,{children:t})})}))}function ue(e){return{id:"simple-tab-".concat(e),"aria-controls":"simple-tabpanel-".concat(e)}}var de=Object(L.a)((function(e){return{root:{flexGrow:1,backgroundColor:e.palette.background.paper}}})),be=function(){var e=de(),t=c.a.useState(0),a=Object(W.a)(t,2),n=a[0],r=a[1];return Object(l.jsxs)("div",{className:e.root,children:[Object(l.jsx)(ae.a,{position:"static",children:Object(l.jsxs)(ne.a,{value:n,onChange:function(e,t){r(t)},"aria-label":"simple tabs example",children:[Object(l.jsx)(ce.a,Object(v.a)({label:"Your Profile"},ue(0))),Object(l.jsx)(ce.a,Object(v.a)({label:"Submit New Request"},ue(1))),Object(l.jsx)(ce.a,Object(v.a)({label:"Your Requests"},ue(2)))]})}),Object(l.jsx)(je,{value:n,index:0,children:Object(l.jsx)(te,{})}),Object(l.jsx)(je,{value:n,index:1,children:Object(l.jsx)(oe,{})}),Object(l.jsx)(je,{value:n,index:2,children:Object(l.jsx)(le,{})})]})},he=function(){return Object(l.jsxs)(c.a.Fragment,{children:["wtf",Object(l.jsx)(Y,{}),Object(l.jsx)(be,{})]})},me=function(){var e=g(T),t=p(),a=function(){B.a.get("/api/get_all_reqs").then((function(e){console.log("response",e);var a=e.data;t(I(a))})).catch((function(e){console.log("There was an error: ",e)}))};Object(n.useMemo)((function(){a()}),[]);var r=function(t,n){console.log("event",t);var c={resolution:t.target.parentNode.name,objectId:n,resolver:"".concat(e.currentUser.firstName," ").concat(e.currentUser.lastName," (").concat(e.currentUser.userID,")")};B.a.put("/api/resolve_request",c).then((function(e){console.log("response",e),a()})).catch((function(e){console.log("There was an error: ",e)}))};return Object(l.jsx)("div",{children:Object(l.jsx)(c.a.Fragment,{children:Object(l.jsx)(Q.a,{component:Z.a,children:Object(l.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(l.jsx)(V.a,{children:Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{children:"Requested By"}),Object(l.jsx)(K.a,{align:"right",children:"Justification"}),Object(l.jsx)(K.a,{align:"right",children:"Amount"}),Object(l.jsx)(K.a,{align:"right",children:"Status"}),Object(l.jsx)(K.a,{align:"right",children:"Resolved By"})]})}),Object(l.jsx)(H.a,{children:e.allReimbursementsState.map((function(e){return Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{component:"th",scope:"row",children:e.requesterID}),Object(l.jsx)(K.a,{align:"right",children:e.justification}),Object(l.jsx)(K.a,{align:"right",children:e.amount}),Object(l.jsx)(K.a,{align:"right",children:"Pending"===e.status?Object(l.jsxs)(c.a.Fragment,{children:[Object(l.jsx)(i.a,{name:"Approved",onClick:function(t){r(t,e.customId)},children:"Approve"}),Object(l.jsxs)(i.a,{name:"Denied",onClick:function(t){r(t,e.customId)},children:[" ","Deny"]})]}):e.status}),Object(l.jsx)(K.a,{align:"right",children:e.resolvedBy?e.resolvedBy:"Unresolved"})]},e.id.timestamp)}))})]})})})})},Oe=function(){var e=g(T),t=p();return Object(n.useMemo)((function(){B.a.get("/api/get_all_employees").then((function(e){console.log("response: ",e);var a=e.data;t(F(a))})).catch((function(e){console.log("There was an error: ",e)}))}),[]),Object(l.jsx)("div",{children:Object(l.jsx)(Q.a,{component:Z.a,children:Object(l.jsxs)(z.a,{className:ee.a.table,"aria-label":"reimbursement table",children:[Object(l.jsx)(V.a,{children:Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{children:"Employee ID"}),Object(l.jsx)(K.a,{align:"right",children:"First Name"}),Object(l.jsx)(K.a,{align:"right",children:"Last Name"})]})}),Object(l.jsx)(H.a,{children:e.employeesState.map((function(e){return Object(l.jsxs)(X.a,{children:[Object(l.jsx)(K.a,{component:"th",scope:"row",children:e.userID}),Object(l.jsx)(K.a,{align:"right",children:e.firstName}),Object(l.jsx)(K.a,{align:"right",children:e.lastName})]},e.id.timestamp)}))})]})})})};function pe(e){var t=e.children,a=e.value,n=e.index,c=Object(G.a)(e,["children","value","index"]);return Object(l.jsx)("div",Object(v.a)(Object(v.a)({role:"tabpanel",hidden:a!==n,id:"simple-tabpanel-".concat(n),"aria-labelledby":"simple-tab-".concat(n)},c),{},{children:a===n&&Object(l.jsx)(se.a,{p:3,children:Object(l.jsx)(re.a,{children:t})})}))}function ge(e){return{id:"simple-tab-".concat(e),"aria-controls":"simple-tabpanel-".concat(e)}}var xe=Object(L.a)((function(e){return{root:{flexGrow:1,backgroundColor:e.palette.background.paper}}})),fe=function(){var e=xe(),t=c.a.useState(0),a=Object(W.a)(t,2),n=a[0],r=a[1];return Object(l.jsxs)("div",{className:e.root,children:[Object(l.jsx)(ae.a,{position:"static",children:Object(l.jsxs)(ne.a,{value:n,onChange:function(e,t){r(t)},"aria-label":"simple tabs example",children:[Object(l.jsx)(ce.a,Object(v.a)({label:"Your Profile"},ge(0))),Object(l.jsx)(ce.a,Object(v.a)({label:"All Employees"},ge(1))),Object(l.jsx)(ce.a,Object(v.a)({label:"All Reimbursement Requests"},ge(2)))]})}),Object(l.jsx)(pe,{value:n,index:0,children:Object(l.jsx)(te,{})}),Object(l.jsx)(pe,{value:n,index:1,children:Object(l.jsx)(Oe,{})}),Object(l.jsx)(pe,{value:n,index:2,children:Object(l.jsx)(me,{})})]})},ve=function(){return Object(l.jsxs)(c.a.Fragment,{children:[Object(l.jsx)(Y,{}),Object(l.jsx)(J,{}),Object(l.jsx)(fe,{})]})},Se=function(){return Object(l.jsx)("div",{children:"No such user exists"})},ye=function(){return Object(l.jsx)("div",{children:"Invalid Password"})},we=a(47),_e=function(){return Object(l.jsx)("div",{children:"This will be the header."})};var Ne=function(){return Object(l.jsxs)(we.a,{children:[Object(l.jsx)(_e,{}),Object(l.jsxs)(o.c,{children:[Object(l.jsx)(o.a,{exact:!0,path:"/",children:Object(l.jsx)(j,{})}),Object(l.jsx)(o.a,{exact:!0,path:"/login",children:Object(l.jsx)(M,{})}),Object(l.jsx)(o.a,{exact:!0,path:"/employee_home",children:Object(l.jsx)(he,{})}),Object(l.jsx)(o.a,{exact:!0,path:"/manager_home",children:Object(l.jsx)(ve,{})}),Object(l.jsx)(o.a,{exact:!0,path:"/invalid_password",children:Object(l.jsx)(ye,{})}),Object(l.jsx)(o.a,{exact:!0,path:"/no_such_user",children:Object(l.jsx)(Se,{})})]})]})},Ce=Object(S.a)({reducer:{salamander:k}}),Re=function(e){e&&e instanceof Function&&a.e(3).then(a.bind(null,185)).then((function(t){var a=t.getCLS,n=t.getFID,c=t.getFCP,r=t.getLCP,s=t.getTTFB;a(e),n(e),c(e),r(e),s(e)}))};s.a.render(Object(l.jsx)(c.a.StrictMode,{children:Object(l.jsx)(O.a,{store:Ce,children:Object(l.jsx)(Ne,{})})}),document.getElementById("root")),Re()},29:function(e,t,a){e.exports={App:"Salamander_App__2LeMn","App-logo":"Salamander_App-logo__3zLcd",table:"Salamander_table__2Piwo"}}},[[132,1,2]]]);
//# sourceMappingURL=main.d4e90e0e.chunk.js.map