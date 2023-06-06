package com.acercadehtml.control;

public class StringOperations {

    public StringBuilder insertTitle(StringBuilder template, String title){
        int index = getTitleIndex(template);
        template.insert(index, title);
        return template;
    }

    public StringBuilder insertKeywords(StringBuilder template, String keywords){
        int index = getKeywordsIndex(template);
        template.insert(index, keywords);
        return template;
    }

    public StringBuilder insertDescription(StringBuilder template, String description){
        int index = getDescriptionIndex(template);
        template.insert(index, description);
        return template;
    }

    public int getTitleIndex(StringBuilder template){
        return template.indexOf("<title></title>")+7;
    }

    public int getKeywordsIndex(StringBuilder template){
        return template.indexOf("<meta name=\"keywords\" content=\"")+31;
    }

    public int getDescriptionIndex(StringBuilder template){
        return template.indexOf("<meta name=\"description\" content=\"")+34;
    }
}
