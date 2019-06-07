package ru.xsd.lettergame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.xsd.lettergame.base.BaseScreen;
import ru.xsd.lettergame.math.Rect;
import ru.xsd.lettergame.sprite.Background;
import ru.xsd.lettergame.sprite.Catcher;

public class MenuScreen extends BaseScreen {
    private Texture backgroundTexture;
    private Background background;

    private Texture catcherTexture;
    private Catcher catcher;


    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("background.jpg");
        background = new Background(new TextureRegion(backgroundTexture));
        catcherTexture = new Texture("frog.png");
        catcher = new Catcher(new TextureRegion(catcherTexture));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(backgroundTexture, 0, 0);
        background.draw(batch);
        catcher.draw(batch, touch);
//		batch.draw(catcherTexture, frogPosition.x, frogPosition.y, 0.1f, 0.1f);
		batch.end();


    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        catcherTexture.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        catcher.resize(worldBounds);
        super.resize(worldBounds);
    }

    //    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        super.touchDown(screenX, screenY, pointer, button);
//        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
//        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
//        return false;
//    }
}
