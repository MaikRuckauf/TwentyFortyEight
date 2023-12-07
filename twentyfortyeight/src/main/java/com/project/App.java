package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        VBox main = new VBox();
		main.setStyle("-fx-background-color: #ffe49c");
        
		// Top Header
		HBox header = new HBox();		

		// 2048 Tile
		StackPane layoutTitle = new StackPane();
		Text title = new Text("2048");
		title.setFont(new Font(40));
		title.setFill(Color.WHITE);
		Rectangle titleBackground = new Rectangle(100, 100);
		titleBackground.setStyle("-fx-fill: gold");
		layoutTitle.getChildren().addAll(titleBackground, title);
		layoutTitle.setPadding(new Insets(0,20,0,20));

		// Score Tile
		StackPane layoutScore = new StackPane();
		VBox scoreContainer = new VBox();
		scoreContainer.setAlignment(Pos.CENTER);
		scoreContainer.setPadding(new Insets(0,0,20,0));

		Text score = new Text("SCORE");
		score.setFont(new Font(20));
		score.setFill(Color.LIGHTGREY);
		
		Text scoreValue = new Text("0");
		scoreValue.setFont(new Font(25));
		scoreValue.setFill(Color.WHITE);

		Rectangle scoreBackground = new Rectangle(100, 100);
		scoreBackground.setStyle("-fx-fill: grey");

		scoreContainer.getChildren().addAll(score, scoreValue);
		layoutScore.getChildren().addAll(scoreBackground, scoreContainer);
		
		// Highest Score Tile - Functionality to be created once DB is connected, temp value set to 0
		StackPane layoutHighscore = new StackPane();
		VBox highscoreContainer = new VBox();
		highscoreContainer.setAlignment(Pos.CENTER);
		highscoreContainer.setPadding(new Insets(0,0,20,0));

		Text highscore = new Text("BEST");
		highscore.setFont(new Font(20));
		highscore.setFill(Color.LIGHTGREY);
		
		Text highscoreValue = new Text("7248");
		highscoreValue.setFont(new Font(25));
		highscoreValue.setFill(Color.WHITE);

		Rectangle highscoreBackground = new Rectangle(100, 100);
		highscoreBackground.setStyle("-fx-fill: grey");

		highscoreContainer.getChildren().addAll(highscore, highscoreValue);
		layoutHighscore.getChildren().addAll(highscoreBackground, highscoreContainer);

		// Reset Button
		StackPane layoutReset = new StackPane();

		Text reset = new Text("RESET");
		reset.setFont(new Font(10));
		reset.setFill(Color.WHITE);

		Rectangle resetBackground = new Rectangle(100, 30);
		resetBackground.setStyle("-fx-fill: orange");

		layoutReset.getChildren().addAll(resetBackground, reset);
		layoutReset.setPadding(new Insets(15,0,0,0));
		
		// Leaderboard Button - Functionality to be created once DB is connected, temp doesn't work
		StackPane layoutLeaderboard = new StackPane();

		Text leaderboard = new Text("LEADERBOARD");
		leaderboard.setFont(new Font(10));
		leaderboard.setFill(Color.WHITE);

		Rectangle leaderboardBackground = new Rectangle(100, 30);
		leaderboardBackground.setStyle("-fx-fill: orange");

		layoutLeaderboard.getChildren().addAll(leaderboardBackground, leaderboard);
		layoutLeaderboard.setPadding(new Insets(15,0,0,0));

		// VBox for Score Display and Reset Button
		VBox scoreResetContainer = new VBox();
		scoreResetContainer.getChildren().addAll(layoutScore, layoutReset);
		scoreResetContainer.setPadding(new Insets(50,10,0,10));

		// VBox for Highscore and Leaderboard Button
		VBox highscoreLeaderboardContainer = new VBox();
		highscoreLeaderboardContainer.getChildren().addAll(layoutHighscore, layoutLeaderboard);
		highscoreLeaderboardContainer.setPadding(new Insets(50,10,0,10));

		// Left and Right Pane for spacing
		Pane leftPane = new Pane();
		HBox.setHgrow(leftPane, Priority.ALWAYS);
		Pane rightPane = new Pane();
		HBox.setHgrow(rightPane, Priority.ALWAYS);

		header.getChildren().addAll(leftPane, layoutTitle, scoreResetContainer, highscoreLeaderboardContainer, rightPane);

		// Game tooltip
		Label tooltip = new Label("Join the numbers and get to the 2048 tile!");
		tooltip.setFont(new Font(20));
		tooltip.setMaxWidth(Double.MAX_VALUE);
		AnchorPane.setLeftAnchor(tooltip, 0.0);
		AnchorPane.setRightAnchor(tooltip, 0.0);
		tooltip.setAlignment(Pos.CENTER);
		tooltip.setPadding(new Insets(20));

		// Bottom Game Grid
		GridPane gameGrid = new GridPane();
		//GridPane.setColumnSpan(gameGrid, 4);
		//GridPane.setRowSpan(gameGrid, 4);
		for (int i = 0; i < 4; i++) {
			gameGrid.getColumnConstraints().add(new ColumnConstraints(100));
			gameGrid.getRowConstraints().add(new RowConstraints(100));
		}
		gameGrid.setGridLinesVisible(true);
		gameGrid.setAlignment(Pos.BOTTOM_CENTER);


		// Parent Structure
        main.getChildren().addAll(header, tooltip, gameGrid);
        scene = new Scene(main, 750, 900);
        //scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
		stage.setMinWidth(550);
		stage.setMinHeight(750);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}