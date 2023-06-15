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
    public void save(String path) {
        FileInteractor.WriteFile(path, html);
    }

    /**
     *
     * @param tag Text to be replaced, example: ${keywords}
     * @param content New content to insert
     * @return TRUE if replaced FALSE if not
     */
    public boolean replaceContent(String tag, String content){
        int index = html.indexOf(tag);
        if(index >= 0){
            html.replace(index, index+tag.length(), content);
            return true;
        }
        return false;
    }

    //Menu funciona pero se puede mejorar (Hacer más estándar)
    public void setActiveMenuTab(int activeTabNumber, int menuSize, String tag){
        for(int i = 1; i<=menuSize; i++){
            if(i == activeTabNumber){
                replaceContent(formatNumberedTag(tag, i), " class=\"actual\"");
            }else{
                replaceContent(formatNumberedTag(tag, i), "");
            }
        }
    }

    public void setBreadcrumbs(String path){
        StringBuilder breadcrumbs = new StringBuilder();
        //Dividir path
        System.out.println(path);
        String[] splitPath = path.split("/");
        for(int i = 1; i < splitPath.length; i++){
            breadcrumbs.append(buildBreadcrumbsNode(splitPath[i-1], i, false));
        }
        breadcrumbs.append(buildBreadcrumbsNode(splitPath[splitPath.length-1], splitPath.length, true));
        System.out.println("- - - - - - - - - - - - - - -");
        System.out.println(breadcrumbs.toString());
        System.out.println("-----------------------------");
    }

    public StringBuilder buildBreadcrumbsNode(String title, int position, boolean isTheLastNode){
        StringBuilder node = new StringBuilder("<li itemprop=\"itemListElement\" itemscope itemtype=\"https://schema.org/ListItem\">\n");
        if(isTheLastNode){
            node.append(getTitleCode(title, null));
        }else{
            node.append(getTitleCode(title, formatLink(title)));
            node.append(getArrowCode());
        }
        node.append(getPositionCode(position));
        node.append("</li>\n");
        return node;
    }
    public String formatLink(String title){
        if(title == null || title.isBlank() || title.equalsIgnoreCase("inicio")){
            return "/";
        }
        return "/"+title.toLowerCase().replace(' ', '-').concat(".html");
    }
    public String getTitleCode(String title, String link){
        if(link==null){
            return "    <span itemprop=\"name\">"+title+"</span>\n";
        }else{
            return "    <a itemprop=\"item\" href=\""+link+"\"><span itemprop=\"name\">"+title+"</span></a>\n";
        }
    }
    public String getArrowCode(){
        return "    <span><img src=\"/images/arrow.png\" alt=\">\"></span>\n";
    }
    public String getPositionCode(int position){
        return "    <meta itemprop=\"position\" content=\""+position+"\">\n";
    }

    /**
     * Replace # symbol for the specified number
     * @param tag ${nav#}
     * @param number 2
     * @return ${nav2}
     */
    private String formatNumberedTag(String tag, int number){
        return tag.replace("#", ""+number);
    }

    public StringBuilder getHtml() {
        return html;
    }
}
