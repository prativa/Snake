package screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.mygdxgame.SnakeGame;


public class MenuScreen extends GameScreen{
	
	
	private TextButton start;
	private Image background;
	private TextButton option;
	private TextButton score;

	
	public MenuScreen(SnakeGame game) {
		super(game);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor( 0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.stage.act();
		this.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.stage = new Stage(800, 480, true);
		this.manager = SnakeGame.getManager();
		this.atlas = manager.get("Game/texture.atlas", TextureAtlas.class);
		Skin skin = new Skin(Gdx.files.internal("UI/skin.json"), this.atlas);
		
		start = new TextButton("Start!", skin);
		start.setWidth(150);
		start.setHeight(30);
		start.setX(400-start.getWidth()/2);
		start.setY(200);
		start.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				Gdx.app.log("", "click on start");
				SnakeScreen snake = new SnakeScreen(game);
				game.setScreen(snake);
			}	
		});
		
		option = new TextButton("Option", skin);
		option.setWidth(150);
		option.setHeight(30);
		option.setX(400-option.getWidth()/2);
		option.setY(start.getY()-option.getHeight()-10);
		option.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				OptionScreen option = new OptionScreen(game);
				game.setScreen(option);
			}
		});
		
		score = new TextButton("Score", skin);
		score.setWidth(150);
		score.setHeight(30);
		score.setX(400 - score.getWidth()/2);
		score.setY(option.getY() - score.getHeight()-10);
		score.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
				Gdx.app.log("", "" + event.toString());
			}

			@Override
			public boolean isOver() {
				// TODO Auto-generated method stub
				return super.isOver();
			}
		});
		
		
		background = new Image(this.atlas.findRegion("titleimage"));
		
		this.stage.addActor(background);
		this.stage.addActor(start);
		this.stage.addActor(option);
		this.stage.addActor(score);
		
		Gdx.input.setInputProcessor(stage);//
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
