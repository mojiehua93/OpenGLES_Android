package com.android.airhockey;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by danny on 2019/5/23.
 */

public class AirHockeyRenderer implements GLSurfaceView.Renderer {

    public static final int POSITION_COMPONENT_COUNT = 2;
    public static final int BYTES_PER_FLOAT = 4;
    private final FloatBuffer mVertexData;

    private float[] mModelMatrix  = new float[16];
    private float[] mViewMatrix = new float[16];
    private float[] mProjectionMatrix = new float[16];
    private float[] mMVPMatrix = new float[16];

//    private final FloatBuffer mTriangle1Vertices;
//    private final FloatBuffer mTriangle2Vertices;
//    private final FloatBuffer mTriangle3Vertices;

    public AirHockeyRenderer() {
        float[] tableVerticesWithTriangles = {
                //三角形1
                0f, 0f,
                9f, 14f,
                0f, 14f,
                //三角形2
                0f, 0f,
                9f, 0f,
                9f, 14f,
                //中线
                0f, 7f,
                9f, 7f,
                //木槌
                4.5f, 2f,
                4.5f, 12f
        };

        mVertexData = ByteBuffer.allocateDirect(tableVerticesWithTriangles.length * BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();

        mVertexData.put(tableVerticesWithTriangles);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
