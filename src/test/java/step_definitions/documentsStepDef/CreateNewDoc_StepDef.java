package step_definitions.documentsStepDef;

import base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.docsTestPages.LandingNewDocPage;
import pageObjects.docsTestPages.NewDocPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateNewDoc_StepDef {

    private HomePage homePage = new HomePage();

    private NewDocPage newDocPage = new NewDocPage();
    //String filePath = "Users\\gzabu\\Documents\\Practice_folder_crm_newDoc";

    private LandingNewDocPage landingNewDocPage = new LandingNewDocPage();

    @When("^User clicks on Docs button and New Document button$")
    public void user_clicks_on_Docs_button_and_New_Document_button() throws InterruptedException {
       // homePage.clickOn_DocsTab();
        homePage.clickOn_NewDocumentOption();
    }

    @When("^User fills up the form$")
    public void user_fills_up_the_form() throws InterruptedException {
       newDocPage.enterTitle("Game document");
       newDocPage.enterDescription("Here is new game document excel worksheet with attach folder");
       newDocPage.enterVersion("1.0");
       newDocPage.selectFolder("C:\\Users\\gzabu\\Documents\\Practice_folder_crm_newDoc");
       newDocPage.ClickOverwriteFileBtne();
      // newDocPage.selectDropDownOption(0);
       newDocPage.enterRestOfTheCredentials(new String[]{"1234567899",
                                                        "teklab",
                                                        "Create a popular new game feature",
                                                        "task4",
                                                        "successful game creation case_No.1",
                                                        "game test "});
       newDocPage.clickSaveBtn();
    }

    @Then("^User should successfully save the document$")
    public void user_should_successfully_save_the_document() throws InterruptedException {
        landingNewDocPage.DocumentSavedSuccessfully();
        assertThat(landingNewDocPage.DocumentSavedSuccessfully()).isTrue();
    }
}
