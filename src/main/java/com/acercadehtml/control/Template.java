package com.acercadehtml.control;

public class Template {

    StringBuilder html;

    public Template(){
        html = FileInteractor.ReadFile("template.html");
    }
    public Template(String path){
        html = FileInteractor.ReadFile(path);
    }

    public void save() {
        FileInteractor.WriteFile("output.html", html);
    }

    /**
     *
     * @param tag ${tag_name} ex: ${keywords}
     * @param content new content to insert
     */
    public void insertContent(String tag, String content){
        int index = html.indexOf(tag);
        if(index >= 0){
            html.replace(index, index+tag.length(), content);
        }
    }


    public StringBuilder getHtml() {
        return html;
    }
}
