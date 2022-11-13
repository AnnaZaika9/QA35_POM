package tests;

import manage.ConfigurationWiki;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class Login extends ConfigurationWiki {
    @Test
    public void login1(){
        User user = User.builder().userName("Nikita5588").password("Nik987654$").build();
//niki5588@ukr.net
        boolean isLogged = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginButton()
                .fillInLoginForm(user)
                .clickOnFlowButton()
                .isLogged();
        Assert.assertTrue(isLogged);

    }
    @Test
    public void login2(){
        String inf= new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginButton()
                .fillInLoginForm(User.builder().userName("Nikita5588").password("Nik987654$").build())
                .clickOnFlowButton()
                .logOut()
                .clickOnFlowButton()
                .getInf();

        Assert.assertEquals(inf,"Log in to Wikipedia");
    }

    @Test
    public void login3() {
        new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginButton()
                .fillInLoginForm2("Nikita5588", "Nik987654$")
                .clickOnFlowButton()
                .logOut();

    }

    @Test
    public void login4() {
        User user = User.builder().userName("Nikita5588").password("Nik987654$").build();
        String info = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginButton()
                .fillInLoginForm(user)
                .clickOnFlowButton()
                .getInfo();
        Assert.assertEquals(info,"Nikita5588");
    }
    @Test
    public void login5() {
        User user = User.builder().userName("Nikita5588").password("Nik987654$").build();
        String logOut = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginButton()
                .fillInLoginForm(user)
                .clickOnFlowButton()
                .getLog();
        Assert.assertEquals(logOut,"Log out");


    }




}
