/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.istic.taa.jaxrs;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DaoProject;
import dao.DaoTask;
import dao.DaoTheme;
import dao.SingletonManager;
import domain.Project;
import domain.Task;
import domain.Theme;

@Path("/status")
public class StatusEndpoint {

    //private static final Logger logger = Logger.getLogger(StatusEndpoint.class.getName());

	private static final EntityManager em = SingletonManager.getInstance().getManager();
	
    private DaoTask daoTask = new DaoTask(em);
    private DaoProject daoProject = new DaoProject(em);
    private DaoTheme daoTheme = new DaoTheme(em);
    
    @GET
    public Response getStatus() {

        return Response.status(Response.Status.OK).entity("JO").build();
    }
    
    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects(){
    	return daoProject.findProjects();
    }
    
    @GET
    @Path("/projects/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProjectById(@PathParam("id")Long id){
    	return daoProject.findProjectById(id);
    }
    
    @GET
    @Path("/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks(){
    	return daoTask.findTasks();
    }
    
    @GET
    @Path("/tasks/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTaskById(@PathParam("id")Long id){
    	return daoTask.findTaskById(id);
    }
    
    @GET
    @Path("/themes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Theme> getThemes(){
    	return daoTheme.findThemes();
    }
    
    @GET
    @Path("/themes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Theme getThemeById(@PathParam("id")Long id){
    	return daoTheme.findThemeById(id);
    }
}

