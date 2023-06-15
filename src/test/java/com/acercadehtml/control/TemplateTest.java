package com.acercadehtml.control;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateTest {

    Template template;

    @Before
    public void before(){
        template = new Template();
    }

    @Test
    public void formatLinkTest(){
        Assert.assertEquals("/", template.formatLink(""));
        Assert.assertEquals("/", template.formatLink("   "));
        Assert.assertEquals("/", template.formatLink(null));
        Assert.assertEquals("/", template.formatLink("inicio"));
        Assert.assertEquals("/", template.formatLink("IniCIO"));
        Assert.assertEquals("/inicio-pagina_alterna.html", template.formatLink("inicio-Pagina_ALTERNA"));
        Assert.assertEquals("/pagina-con-espacios-en-blanco.html", template.formatLink("Pagina con espacios EN BLANCO"));
        Assert.assertEquals("/pagina.html", template.formatLink("pagina"));

    }

}
