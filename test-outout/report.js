$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login to Application",
  "description": "",
  "id": "login-to-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Test Login Test Scenario",
  "description": "",
  "id": "login-to-application;test-login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@demo"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user initiate browser and Opens the application",
  "keyword": "Given "
});
formatter.match({
  "location": "loginStepDefination.user_initiate_browser_and_Opens_the_application()"
});
formatter.result({
  "duration": 8821251139,
  "status": "passed"
});
});