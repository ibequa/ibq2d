package testgame;

import com.ibq2d.engine.Application;
import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class Edges extends GameListener {

    EdgeCollider rightEdge;
    EdgeCollider leftEdge;

    @Override
    public void awake() {
        leftEdge = new EdgeCollider(new Edge(new Vector2(-Application.WIDTH / 2, -Application.HEIGHT / 2),
                new Vector2(-Application.WIDTH / 2, Application.HEIGHT / 2)), false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                if (collider.tag.equals("Ball"))
                    bounceBallBack(Vector2.right(), collider.rigidBody.getVelocity());
            }
        });

        rightEdge = new EdgeCollider(new Edge(new Vector2(Application.WIDTH / 2, -Application.HEIGHT / 2),
                    new Vector2(Application.WIDTH / 2, Application.HEIGHT / 2)), false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                if (collider.tag.equals("Ball"))
                    bounceBallBack(Vector2.left(), collider.rigidBody.getVelocity());
            }
        });
    }

    void bounceBallBack(Vector2 normal, Vector2 velocity) {
        velocity.setX(-velocity.getX());
    }
}
