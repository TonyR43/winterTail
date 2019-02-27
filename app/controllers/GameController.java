package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

public class GameController
		extends Controller
	{
		private FormFactory formFactory;
		final private String CHARACTER_NAME_SESSION_KEY = "CHARACTER_NAME";
		@Inject
		
		public GameController ( FormFactory formFactory )
			{
				this.formFactory = formFactory;
			}
		
		public Result getCreateCharacter ( )
			{
				return ok ( views.html.createcharacter.render ( ) );
			}
		
		public Result postCreateCharacter ( Http.Request request )
			{
				DynamicForm name = formFactory
						.form ( )
						.bindFromRequest ( request );
				String characterName = name.get ( "characterName" );
				return ok(views.html.start.render()).addingToSession(request, CHARACTER_NAME_SESSION_KEY, characterName);
			}
		
		public Result getStart ( )
			{
				return ok ( views.html.start.render ( ) );
			}
		
		public Result postStart ( )
			{
				return ok ( views.html.outsidecabin.render ( ) );
			}
		
		public Result postForest ( )
			{
				return ok ( views.html.forest.render ( ) );
			}
	}
