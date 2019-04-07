package step_definitions;

import base.PageBase;
import base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.DemoPageObjects;
import pageObjects.Hipmunk;
import pageObjects.LoginPage;

public class Demo_StepDef extends PageBase {

  private DemoPageObjects demoPageObjects = new DemoPageObjects();
  private Hipmunk hipmunk = new Hipmunk();
  private LoginPage loginPage;

  @And("User highlights all header nav tabs")
  public void User_highlights_all_header_nav_tabs() throws InterruptedException {
    demoPageObjects.highLight_AllHeaderTabs();
  }

  @And("User highlights all left side menu lists")
  public void User_highlights_all_left_side_menu_lists() throws InterruptedException {
    demoPageObjects.highLight_AllLeftMenuLists();
  }

  @And("User highlights Weeks")
  public void User_highlights_Weeks() throws InterruptedException {
    demoPageObjects.highLight_weeks();
  }

  @And("User highlights calendar")
  public void User_highlights_calendar() throws InterruptedException {
    demoPageObjects.highLight_calendar();
  }

  @And("User hover overs header nav tabs")
  public void User_hover_overs_header_nav_tabs() throws InterruptedException {
    demoPageObjects.hoverOverHeadNavTabs();
  }

  @And("User should verify left menu pages")
  public void User_should_verify_left_menu_pages() throws InterruptedException {
    demoPageObjects.leftShouldMenuListsDisplayCorrectPages();
  }

  @And("User should be able to create a new deal")
  public void User_should_be_able_to_create_a_new_deal() {
    demoPageObjects.createNewDeal();
    demoPageObjects.fillOutForm();
  }

  @Given("^User goes to Hipmunk$")
  public void user_goes_to_Hipmunk() {
    loginPage = new LoginPage(TestBase.getDriver(), "hipmunk");
  }

  @When("^User searches for a flight ticket from VA to CA")
  public void user_searches_for_a_flight_ticket_from_VA_to_CA()
      throws InterruptedException {
    hipmunk.fillOutFlightInformationTable();
  }

  @Then("^User should be provided with best deals$")
  public void user_should_be_provided_with_best_deals() {
  }

}
