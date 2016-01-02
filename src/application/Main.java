package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Video.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Stage videoStage = new Stage();
		videoStage.initOwner(primaryStage);
		try {
            // シーングラフを作成
            BorderPane  root        = new BorderPane();
            // 動画ファイルのパスを取得
            File f = new File( "C:\\Users\\Shohei\\Desktop\\test.m4v" );
            // 動画再生クラスをインスタンス化
            Media       Video       = new Media( f.toURI().toString() );
            MediaPlayer Play        = new MediaPlayer(Video);
            MediaView   mediaView   = new MediaView(Play);
            mediaView.setFitWidth( 700 );
            root.setCenter( mediaView );
            // シーンを追加
            Scene   scene   = new Scene( root,700,700);
            // ステージ設定
            videoStage.setTitle( "VideoPlay" );
            videoStage.setScene( scene );
            videoStage.show();
            // 動画再生開始
            Play.play();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
