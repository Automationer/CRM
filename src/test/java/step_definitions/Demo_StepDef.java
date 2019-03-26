package step_definitions;

import static org.assertj.core.api.Assertions.assertThat;

import base.PageBase;
import cucumber.api.java.en.And;
import pageObjects.LandingPage;

public class Demo_StepDef extends PageBase {

  private LandingPage landingPage = new LandingPage();

  @And("User highlights all header nav tabs")
  public void User_highlights_all_header_nav_tabs() throws InterruptedException {
    landingPage.highLight_AllHeaderTabs();
  }

  @And("User highlights all left side menu lists")
  public void User_highlights_all_left_side_menu_lists() throws InterruptedException {
    landingPage.highLight_AllLeftMenuLists();
  }

  @And("User highlights Weeks")
  public void User_highlights_Weeks() throws InterruptedException {
    landingPage.highLight_weeks();
  }

  @And("User highlights calendar")
  public void User_highlights_calendar() throws InterruptedException {
    landingPage.highLight_calendar();
  }

  @And("User hover overs header nav tabs")
  public void User_hover_overs_header_nav_tabs() throws InterruptedException {
    landingPage.hoverOverHeadNavTabs();
  }

  @And("User should be able to create a new deal")
  public void User_should_be_able_to_create_a_new_deal() {
    landingPage.createNewDeal();
    landingPage.fillOutForm().forEach(a -> assertThat(a).isTrue());
  }

}
