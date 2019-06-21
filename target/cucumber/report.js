$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("crm_features/Login.feature");
formatter.feature({
  "line": 4,
  "name": "Login   Gherkin language",
  "description": "",
  "id": "login---gherkin-language",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@SmokeTest"
    },
    {
      "line": 2,
      "name": "@LoginFeature"
    }
  ]
});
formatter.before({
  "duration": 35371102,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "User should be able to Successfully login with valid username and password",
  "description": "",
  "id": "login---gherkin-language;user-should-be-able-to-successfully-login-with-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "User goes to CRM",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User enters valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "User should successfully log into CRM",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_StepDef.user_goes_to_CRM()"
});
formatter.result({
  "duration": 167539602,
  "error_message": "java.lang.NullPointerException\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:787)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:96)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:71)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:45)\n\tat base.PageBase.\u003cinit\u003e(PageBase.java:24)\n\tat pageObjects.LoginPage.\u003cinit\u003e(LoginPage.java:24)\n\tat step_definitions.Login_StepDef.user_goes_to_CRM(Login_StepDef.java:18)\n\tat ✽.Given User goes to CRM(crm_features/Login.feature:7)\n",
  "status": "failed"
});
formatter.match({
  "location": "Login_StepDef.user_enters_valid_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Login_StepDef.user_should_successfully_log_into_CRM()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 38907,
  "status": "passed"
});
formatter.before({
  "duration": 5771039,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "User should not be able to login with valid username and invalid password",
  "description": "",
  "id": "login---gherkin-language;user-should-not-be-able-to-login-with-valid-username-and-invalid-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "User goes to CRM",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User enters valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User should successfully log into CRM",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_StepDef.user_goes_to_CRM()"
});
formatter.result({
  "duration": 403241,
  "error_message": "java.lang.NullPointerException\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:787)\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:96)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:71)\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:45)\n\tat base.PageBase.\u003cinit\u003e(PageBase.java:24)\n\tat pageObjects.LoginPage.\u003cinit\u003e(LoginPage.java:24)\n\tat step_definitions.Login_StepDef.user_goes_to_CRM(Login_StepDef.java:18)\n\tat ✽.Given User goes to CRM(crm_features/Login.feature:13)\n",
  "status": "failed"
});
formatter.match({
  "location": "Login_StepDef.user_enters_valid_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Login_StepDef.user_should_successfully_log_into_CRM()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 26883,
  "status": "passed"
});
});