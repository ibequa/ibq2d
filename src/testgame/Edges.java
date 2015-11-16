package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class Edges extends GameListener {

    EdgeCollider rightEdge;
    EdgeCollider leftEdge;

    @Override
    public void start() {
        leftEdge = new EdgeCollider(new Edge(new Vector2(-Application.WIDTH / 2, -Application.HEIGHT / 2),
                new Vector2(-Application.WIDTH / 2, Application.HEIGHT / 2)), true, new ContactListener() {
            @Override
            public void onTriggerEnter(Collider collider) {
                if (collider.tag == "Ball")
                    bounceBallBack(Vector2.right(), collider.rigidBody.getVelocity());
            }
        });

        rightEdge = new EdgeCollider(new Edge(new Vector2(Application.WIDTH / 2, -Application.HEIGHT / 2),
                    new Vector2(Application.WIDTH / 2, Application.HEIGHT / 2)), true, new ContactListener() {
            @Override
            public void onTriggerEnter(Collider collider) {
                if (collider.tag == "Ball")
                    bounceBallBack(Vector2.left(), collider.rigidBody.getVelocity());
            }
        });
    }

    void bounceBallBack(Vector2 normal, Vector2 velocity) {
        velocity.setX(-velocity.getX());
    }
}
