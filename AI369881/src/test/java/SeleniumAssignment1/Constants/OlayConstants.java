package SeleniumAssignment1.Constants;

public class OlayConstants {

    // XPaths

    public String BUTTON_AddToMyProfile = "//input[contains(@id,'SubmitBtn')]";
    public String BUTTON_Register = "//input[@id='phdesktopbody_0_submit']";
    public String BUTTON_RejectCookies = "//button[@id='onetrust-reject-all-handler']";
    public String BUTTON_SignIn = "//input[@id='phdesktopbody_0_SIGN IN']";
    public String BUTTON_SignIn_Spanish = "//input[@id='phdesktopbody_0_INICIAR SESIÓN']";
    public String BUTTON_SignIn_German = "//input[@id='phdesktopbody_0_ANMELDEN']";
    public String BUTTON_Next = "//input[@id='phdesktopbody_0_NEXT']";
    public String BUTTON_LogOut = "//a[contains(@id,'anchrContinue')]";
    public String ERROR_DuplicateUser = "//span[@id='phdesktopbody_0_ErrorMessage']";
    public String ERROR_InvalidUser = "//span[@id='phdesktopbody_0_Message']";
    public String ERROR_System = "//span[@id='phdesktopbody_0_ErrorMessage']";
    public String IMG_Female = "//img[@id='phdesktopbody_0_imgfemale']";
    public String IMG_Male = "//img[@id='phdesktopbody_0_imgmale']";
    public String LABEL_Header = "//h1[@id='phdesktopbody_0_Header']";
    public String LABEL_YourProfile = "//h1[@id='phdesktopbody_0_TitleText']";
    public String LABEL_YourProfile_Spanish = "//h1[@id='phdesktopbody_1_TitleText']";
    public String LABEL_SocialMedia = "//div[contains(@id,'SocialMediaLinkWrapper')]//li";
    public String LABEL_Footer = "//div[contains(@id,'phdesktopfatfooterarea')]//li";
    public String LABEL_MailSentMessage = "//div[@id='phdesktopbody_0_afterSubmit']";
    public String LINK_Register = "//div[contains(@class,'newsletter')]//a[@class='event_profile_register']";
    public String LINK_SignIn = "//a[@class='event_profile_login']";
    public String LINK_SignOut = "//a[contains(@id,'LogOffLink')]";
    public String LINK_ForgotPassword = "//a[@id='phdesktopbody_0_forgotpassword']";
    public String TEXTBOX_Email = "//input[contains(@id,'account[emails][0][address]')]";
    public String TEXTBOX_Password = "//input[contains(@id,'account[password][password]')]";
    public String TEXTBOX_ConfirmPassword = "//input[contains(@id,'account[password][confirm]')]";
    public String TEXTBOX_FirstName = "//input[contains(@id,'consumer[firstname]')]";
    public String TEXTBOX_SecondName = "//input[contains(@id,'consumer[lastname]')]";
    public String TEXTBOX_MiddleName = "//input[contains(@id,'consumer[secondary_lastname')]";
    public String TEXTBOX_Street = "//input[contains(@id,'t[addresses][0][line1]')]";
    public String TEXTBOX_City = "//input[contains(@id,'[addresses][0][city]')]";
    public String TEXTBOX_Postcode = "//input[contains(@id,'[addresses][0][postalarea]')]";
    public String TEXTBOX_Phone = "//input[contains(@id,'[phones][0][fulltelephonenumber')]";
    public String TEXTBOX_LoginUsername = "//input[@id='phdesktopbody_0_username']";
    public String TEXTBOX_LoginPassword = "//input[@id='phdesktopbody_0_password']";
    public String SELECT_Day = "//select[contains(@id,'consumer[birthdate][day]')]";
    public String SELECT_Month = "//select[contains(@id,'consumer[birthdate][month]')]";
    public String SELECT_Year = "//select[contains(@id,'consumer[birthdate][year]')]";
    public String SELECT_DayGerman = "//select[@data-key='birthdate[dateselect_day]']";
    public String SELECT_MonthGerman = "//select[@data-key='birthdate[dateselect_month]']";
    public String SELECT_YearGerman = "//select[@data-key='birthdate[dateselect_year]']";
    public String SELECT_Land = "//select[contains(@id,'account[addresses][0][country]')]";

    /*Test Data
            User email = OlayTestUser@gmail.com
            Password = OlayPass.123*/

    // Strings

    public String OlayUkUrl = "https://www.olay.co.uk/en-gb";
    // public String OlayChinaUrl = "https://www.olay.com.cn/";
    public String OlayGermanyUrl = "https://www.olaz.de/de-de";
    public String OlaySpainUrl = "https://www.olay.es/es-es";
    public String UserDetailsUrl = "/optionalfieldpage";
    public String Password = "OlayPass.123";
    public String DuplicateUserError = "An account with this email address already exists.";
    public String InvalidUserError = "The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
    public String RegistrationCompleteMsg = "Your Registration Is Complete";
    public String ResetPassword = "Reset Password";
    public String RegistrationCompleteMsg_Spanish = "HAS COMPLETADO EL PROCESO DE REGISTRO";
    public String RegistrationCompleteMsg_German = "Falls Sie zu den glücklichen Gewinnern gehören werden wir sie in Kürze kontaktieren";
    public String YourProfile = "YOUR PROFILE";
    public String YourProfile_Spanish = "TU PERFIL";
    public String YourProfile_German = "Profil Anzeigen";
    public String Spain_Phone = "+34912345678";
    public String SystemError_German = "Ein Systemfehler ist aufgetreten. Bitte versuchen Sie es später erneut.";
    public String MailSentMessage = "We have sent an email to your email address, please click on the link in the email to reset your password.\n" +
            "Didn't receive the e-mail? Return to the Reset Password page to try again.";

}
