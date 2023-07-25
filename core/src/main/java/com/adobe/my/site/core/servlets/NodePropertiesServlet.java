package com.adobe.my.site.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class, property = { "sling.servlet.paths=/bin/node-properties", "sling.servlet.methods=" + HttpConstants.METHOD_GET })

public class NodePropertiesServlet extends SlingSafeMethodsServlet {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {


        // Get the path of the node from the request
        String nodePath = "/content/wknd-site/us/en/dropdown-component-page/jcr:content/root/container/container/dropdown";

        // Get the resource resolver
        ResourceResolver resourceResolver = request.getResourceResolver();

        // Get the resource for the node
        Resource nodeResource = resourceResolver.getResource(nodePath);
//

        //1.entire properties

//        if (nodeResource != null) {
//            // Get the properties of the node as a ValueMap
//            ValueMap properties = nodeResource.getValueMap();
//
//            // Prepare the response with the node properties
//            for (Map.Entry<String, Object> entry : properties.entrySet()) {
//                String propertyName = entry.getKey();
//                Object propertyValue = entry.getValue();
//               // if(propertyName=="continent")
//                response.getWriter().write(propertyName + ": " + propertyValue.toString() + "\n");
//            }
//        } else {
//            response.getWriter().write("Node not found.");




                //2.single property
//            String propertyName = "continent"; // Replace with the name of your desired property
//            Object propertyValue = nodeResource.getValueMap().get(propertyName);
//
//            if (propertyValue != null) {
//                response.getWriter().write(propertyName + ": " + propertyValue.toString());
//            } else {
//                response.getWriter().write("Property not found.");
//            }
//        } else {
//            response.getWriter().write("Node not found.");
//




        //3.specified properties
        String[] propertyNames = { "continent", "country", "state" };

        ValueMap properties = nodeResource.getValueMap();
        for (String propertyName : propertyNames) {
            Object propertyValue = properties.get(propertyName);

            if (propertyValue != null) {
                response.getWriter().write(propertyName + ": " + propertyValue.toString() + "\n");
            } else {
                response.getWriter().write("Property '" + propertyName + "' not found.\n");

    }


        }


    }
}