// learning source
// javaFX
// 1. : General revie (start refresher) - https://www.youtube.com/watch?v=9XJicRt_FaI
// 2. : javaFx Layout - https://www.youtube.com/watch?v=GH-3YRAuHs0
// 3. : GridPane (selected layout root for first layer) - https://www.youtube.com/watch?v=YtKF1JKtRWM

// Biguining of the code
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        // JAVAFX APPLICATION STRUCTURE

        // Stage configuration {title/icone/size..}
        stage.setTitle("myLexiMap");
        Image icon = new Image("icone.png");
        stage.getIcons().add(icon);
        // stage.setWidth(1000);
        // stage.setHeight(800);
        // stage.setResizable(false);
        stage.setFullScreen(true);

        // Root Layout  
        GridPane root = new GridPane();
        // root.setGridLinesVisible(true);

        // layout settings 
        root.setPadding(new Insets(5,5,5,5));
        root.setVgap(10);
        root.setHgap(20);

        // colums and row creation
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25); // Left Sidebare 
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(25);
        root.getColumnConstraints().addAll(col1, col2, col3, col4);
        //----
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25); // Left Sidebare 
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(25);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(25);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(25);
        root.getRowConstraints().addAll(row1, row2, row3, row4);
        // ==== Main Layout blocks ====
        VBox FLayerLeft = new VBox();
        FLayerLeft.getStyleClass().add("FLayerLeft"); // css class
        FLayerLeft.setSpacing(15);
        VBox FLayerCenter = new VBox();
        FLayerCenter.getStyleClass().add("FLayerCenter"); // css class
        HBox FLayerBottom = new HBox(); 
        FLayerBottom.getStyleClass().add("FLayerBottom"); // css class

        // ===== Add merged blocks =====
        root.add(FLayerLeft, 0, 0, 1, 4);     // column 0, row 0, span (how many cells the element covers) 1 col and 4 rows
        root.add(FLayerCenter, 1, 0, 3, 3);   // starts at column 1 and row 0, spans (cover) 3 cols and 3 rows
        root.add(FLayerBottom, 1, 3, 3, 1);   // start at column 1 and row 3 then cover (spans) 3 cols and 1 row  

        // ==== column 0 (FLayerLeft): add VBox ====
        // ------ Setting ------
        VBox lftB_TopBlock = new VBox();
        lftB_TopBlock.getStyleClass().add("lftB_TopBlock"); 
        VBox lftB_CenterBlock = new VBox();
        lftB_CenterBlock.getStyleClass().add("lftB_CenterBlock"); 
        VBox lftB_BottomBlock = new VBox();
        lftB_BottomBlock.getStyleClass().add("lftB_BottomBlock"); 
        FLayerLeft.getChildren().addAll(lftB_TopBlock, lftB_CenterBlock, lftB_BottomBlock);
        // ------- dimensions -------
        lftB_TopBlock.setPrefHeight(215); // set the preferred height of the top block to 200 pixels
        lftB_CenterBlock.setPrefHeight(215);
        lftB_BottomBlock.setPrefHeight(400);
        // ------- child --------------
        // top block
        StackPane lftB_TopB_TitleBloc = new StackPane();
        lftB_TopB_TitleBloc.getStyleClass().add("lftB_TopB_TitleBloc");
        VBox LftB_TopB_ContentBloc = new VBox();
        LftB_TopB_ContentBloc.getStyleClass().add("LftB_TopB_ContentBloc");
        lftB_TopB_TitleBloc.setPrefHeight(50);
        lftB_TopBlock.getChildren().addAll(lftB_TopB_TitleBloc, LftB_TopB_ContentBloc);
        // ------
        Label lbl_lftB_TopTitle = new Label("Performance");
        lbl_lftB_TopTitle.getStyleClass().add("lbl_lftB_TopTitle");
        lftB_TopB_TitleBloc.getChildren().add(lbl_lftB_TopTitle);
        // -------
        HBox lftB_TopB_InfoHBox_status = new HBox();
        lftB_TopB_InfoHBox_status.getStyleClass().add("lftB_TopB_InfoHBox_status"); // css class
        Label lbl_lftB_TopB_InfoStatus = new Label("Status: ");
        lbl_lftB_TopB_InfoStatus.getStyleClass().add("lbl_lftB_TopB_InfoStatus"); // css class 
        Label lbl_lftB_TopB_InfoStatusValue = new Label("Idle");
        lbl_lftB_TopB_InfoStatusValue.getStyleClass().add("lbl_lftB_TopB_InfoStatusValue"); // css class
        lftB_TopB_InfoHBox_status.setSpacing(85);
        lftB_TopB_InfoHBox_status.getChildren().addAll(lbl_lftB_TopB_InfoStatus, lbl_lftB_TopB_InfoStatusValue);

        HBox lftB_TopB_InfoHBox_WrdsProcess = new HBox();
        lftB_TopB_InfoHBox_WrdsProcess.getStyleClass().add("lftB_TopB_InfoHBox_WrdsProcess"); // css class
        Label lbl_lftB_TopB_InfoWrdsProcess = new Label("Words Processed: ");
        lbl_lftB_TopB_InfoWrdsProcess.getStyleClass().add("lbl_lftB_TopB_InfoWrdsProcess"); // css class
        Label lbl_lftB_TopB_InfoWrdsProcessValue = new Label("0");
        lbl_lftB_TopB_InfoWrdsProcessValue.getStyleClass().add("lbl_lftB_TopB_InfoWrdsProcessValue"); // css class
        lftB_TopB_InfoHBox_WrdsProcess.setSpacing(15);
        lftB_TopB_InfoHBox_WrdsProcess.getChildren().addAll(lbl_lftB_TopB_InfoWrdsProcess, lbl_lftB_TopB_InfoWrdsProcessValue);

        HBox lftB_TopB_InfoHBox_UnquWrds = new HBox();
        lftB_TopB_InfoHBox_UnquWrds.getStyleClass().add("lftB_TopB_InfoHBox_UnquWrds"); // css class
        Label lbl_lftB_TopB_InfoUnquWrds = new Label("Unique Words: ");
        lbl_lftB_TopB_InfoUnquWrds.getStyleClass().add("lbl_lftB_TopB_InfoUnquWrds"); // css class
        Label lbl_lftB_TopB_InfoUnquWrdsValue = new Label("0");
        lbl_lftB_TopB_InfoUnquWrdsValue.getStyleClass().add("lbl_lftB_TopB_InfoUnquWrdsValue"); // css class
        lftB_TopB_InfoHBox_UnquWrds.setSpacing(31);
        lftB_TopB_InfoHBox_UnquWrds.getChildren().addAll(lbl_lftB_TopB_InfoUnquWrds, lbl_lftB_TopB_InfoUnquWrdsValue);

        Label lbl_lftB_TopB_InfoUpdate = new Label("");
        lbl_lftB_TopB_InfoUpdate.getStyleClass().add("lbl_lftB_TopB_InfoUpdate");
        LftB_TopB_ContentBloc.setSpacing(25);
        LftB_TopB_ContentBloc.setPadding(new Insets(15, 0, 0, 15)); // Insets(top, right, bottom, left)
        LftB_TopB_ContentBloc.getChildren().addAll(lftB_TopB_InfoHBox_status, lftB_TopB_InfoHBox_WrdsProcess, lftB_TopB_InfoHBox_UnquWrds, lbl_lftB_TopB_InfoUpdate);
        // ------
        // center block
        StackPane lftB_CenterB_TitleBloc = new StackPane();
        lftB_CenterB_TitleBloc.getStyleClass().add("lftB_CenterB_TitleBloc");
        VBox LftB_CenterB_ContentBloc = new VBox();
        LftB_CenterB_ContentBloc.setPadding(new Insets(15, 0, 0, 15)); // Insets(top, right, bottom, left)
        LftB_CenterB_ContentBloc.getStyleClass().add("LftB_CenterB_ContentBloc"); // css class
        lftB_CenterB_TitleBloc.setPrefHeight(50);
        lftB_CenterBlock.getChildren().addAll(lftB_CenterB_TitleBloc, LftB_CenterB_ContentBloc);
        // ------
        Label lbl_lftB_CenterTitle = new Label("Data Overview");
        lbl_lftB_CenterTitle.getStyleClass().add("lbl_lftB_CenterTitle"); // css class
        lftB_CenterB_TitleBloc.getChildren().add(lbl_lftB_CenterTitle);
        // ------ 
        HBox lftB_CenterB_TotlStrdWrdHBox = new HBox();
        lftB_CenterB_TotlStrdWrdHBox.getStyleClass().add("lftB_CenterB_TotlStrdWrdHBox");
        Label lbl_lftB_CenterB_TotlStrdWrd = new Label("Total Stored Words: ");
        lbl_lftB_CenterB_TotlStrdWrd.getStyleClass().add("lbl_lftB_CenterB_TotlStrdWrd"); // css class
        Label lbl_lftB_CenterB_TotlStrdWrdValue = new Label("0");
        lbl_lftB_CenterB_TotlStrdWrdValue.getStyleClass().add("lbl_lftB_CenterB_TotlStrdWrdValue"); // css class
        lftB_CenterB_TotlStrdWrdHBox.setSpacing(34);
        lftB_CenterB_TotlStrdWrdHBox.getChildren().addAll(lbl_lftB_CenterB_TotlStrdWrd, lbl_lftB_CenterB_TotlStrdWrdValue);

        HBox lftB_CenterB_GnrlStrdWrdsHBox = new HBox();
        lftB_CenterB_GnrlStrdWrdsHBox.getStyleClass().add("lftB_CenterB_GnrlStrdWrdsHBox"); // css class
        Label lbl_lftB_CenterB_GnrlStrdWrds = new Label("General Stored Words: ");
        lbl_lftB_CenterB_GnrlStrdWrds.getStyleClass().add("lbl_lftB_CenterB_GnrlStrdWrds"); // css class
        Label lbl_lftB_CenterB_GnrlStrdWrdsValue = new Label("0");
        lbl_lftB_CenterB_GnrlStrdWrdsValue.getStyleClass().add("lbl_lftB_CenterB_GnrlStrdWrdsValue"); // css class
        lftB_CenterB_GnrlStrdWrdsHBox.setSpacing(16);
        lftB_CenterB_GnrlStrdWrdsHBox.getChildren().addAll(lbl_lftB_CenterB_GnrlStrdWrds, lbl_lftB_CenterB_GnrlStrdWrdsValue);

        HBox LftB_CenterB_DtatSzeHBox = new HBox();
        LftB_CenterB_DtatSzeHBox.getStyleClass().add("LftB_CenterB_DtatSzeHBox"); // css class
        Label lbl_LftB_CenterB_DtatSze = new Label("Data Size: ");
        lbl_LftB_CenterB_DtatSze.getStyleClass().add("lbl_LftB_CenterB_DtatSze"); // css class
        Label lbl_LftB_CenterB_DtatSzeValue = new Label("0 MB");
        lbl_LftB_CenterB_DtatSzeValue.getStyleClass().add("lbl_LftB_CenterB_DtatSzeValue"); // css class
        LftB_CenterB_DtatSzeHBox.getChildren().addAll(lbl_LftB_CenterB_DtatSze, lbl_LftB_CenterB_DtatSzeValue);
        LftB_CenterB_DtatSzeHBox.setSpacing(95);
        // ------
        LftB_CenterB_ContentBloc.setSpacing(25);
        // ------
        LftB_CenterB_ContentBloc.getChildren().addAll(lftB_CenterB_TotlStrdWrdHBox, lftB_CenterB_GnrlStrdWrdsHBox, LftB_CenterB_DtatSzeHBox);
        //--------

        // bottom block
        StackPane lftB_BottomB_TitleBloc = new StackPane();
        lftB_BottomB_TitleBloc.getStyleClass().add("lftB_BottomB_TitleBloc");
        VBox LftB_BottomB_ContentBloc = new VBox();
        LftB_BottomB_ContentBloc.setSpacing(75);
        LftB_BottomB_ContentBloc.setPadding(new Insets(35, 0, 0, 15)); // Insets(top, right, bottom, left)
        LftB_BottomB_ContentBloc.getStyleClass().add("LftB_BottomB_ContentBloc");
        lftB_BottomB_TitleBloc.setPrefHeight(50);
        lftB_BottomBlock.getChildren().addAll(lftB_BottomB_TitleBloc, LftB_BottomB_ContentBloc);
        //--------
        Label lbl_lftB_BottomTitle = new Label("Data Analysis");
        lbl_lftB_BottomTitle.getStyleClass().add("lbl_lftB_BottomTitle");
        lftB_BottomB_TitleBloc.getChildren().add(lbl_lftB_BottomTitle);
        //--------
        HBox LftB_BottomB_HeaderHBox = new HBox();
        LftB_BottomB_HeaderHBox.getStyleClass().add("LftB_BottomB_HeaderHBox"); // css class
        HBox LftB_BottomB_TrainingTimeHBox = new HBox();
        LftB_BottomB_TrainingTimeHBox.getStyleClass().add("LftB_BottomB_TrainingTimeHBox"); // css class
        HBox LftB_BottomB_SrchTimeHBox = new HBox();
        LftB_BottomB_SrchTimeHBox.getStyleClass().add("LftB_BottomB_SrchTimeHBox"); // css class
        LftB_BottomB_ContentBloc.getChildren().addAll(LftB_BottomB_HeaderHBox, LftB_BottomB_TrainingTimeHBox, LftB_BottomB_SrchTimeHBox);
        // ------Header line ------
        Label lbl_LftB_BottomB_Header_InfoEmptySpce = new Label("");
        lbl_LftB_BottomB_Header_InfoEmptySpce.getStyleClass().add("lbl_LftB_BottomB_Header_InfoEmptySpce"); // css class
        Label lbl_LftB_BottomB_Header_InfoList = new Label("List");
        lbl_LftB_BottomB_Header_InfoList.getStyleClass().add("lbl_LftB_BottomB_Header_InfoList"); // css class
        Label lbl_LftB_BottomB_Header_InfoBST = new Label("BST");
        lbl_LftB_BottomB_Header_InfoBST.getStyleClass().add("lbl_LftB_BottomB_Header_InfoBST"); // css class
        Label lbl_LftB_BottomB_Header_InfoHashMap = new Label("HashMap");
        lbl_LftB_BottomB_Header_InfoHashMap.getStyleClass().add("lbl_LftB_BottomB_Header_InfoHashMap"); // css class
        LftB_BottomB_HeaderHBox.getChildren().addAll(lbl_LftB_BottomB_Header_InfoEmptySpce, lbl_LftB_BottomB_Header_InfoList, lbl_LftB_BottomB_Header_InfoBST, lbl_LftB_BottomB_Header_InfoHashMap);
        // ------ Training time line ------
        Label lbl_LftB_BottomB_TrainingTime_Info = new Label("Training Time: ");
        lbl_LftB_BottomB_TrainingTime_Info.getStyleClass().add("lbl_LftB_BottomB_TrainingTime_Info"); // css class
        Label lbl_LftB_BottomB_TrainingTime_InfoListValue = new Label("0 ms");
        lbl_LftB_BottomB_TrainingTime_InfoListValue.getStyleClass().add("lbl_LftB_BottomB_TrainingTime_InfoListValue"); // css class
        Label lbl_LftB_BottomB_TrainingTime_InfoBSTValue = new Label("0 ms");
        lbl_LftB_BottomB_TrainingTime_InfoBSTValue.getStyleClass().add("lbl_LftB_BottomB_TrainingTime_InfoBSTValue"); // css class
        Label lbl_LftB_BottomB_TrainingTime_InfoHashMapValue = new Label("0 ms");
        lbl_LftB_BottomB_TrainingTime_InfoHashMapValue.getStyleClass().add("lbl_LftB_BottomB_TrainingTime_InfoHashMapValue"); // css class
        LftB_BottomB_TrainingTimeHBox.getChildren().addAll(lbl_LftB_BottomB_TrainingTime_Info, lbl_LftB_BottomB_TrainingTime_InfoListValue, lbl_LftB_BottomB_TrainingTime_InfoBSTValue, lbl_LftB_BottomB_TrainingTime_InfoHashMapValue);
        // ------ Search time line ------
        Label lbl_LftB_BottomB_SrchTime_Info = new Label("Search Time: ");
        lbl_LftB_BottomB_SrchTime_Info.getStyleClass().add("lbl_LftB_BottomB_SrchTime_Info"); // css class
        Label lbl_LftB_BottomB_SrchTime_InfoListValue = new Label("0 ms");
        lbl_LftB_BottomB_SrchTime_InfoListValue.getStyleClass().add("lbl_LftB_BottomB_SrchTime_InfoListValue"); // css class
        Label lbl_LftB_BottomB_SrchTime_InfoBSTValue = new Label("0 ms");
        lbl_LftB_BottomB_SrchTime_InfoBSTValue.getStyleClass().add("lbl_LftB_BottomB_SrchTime_InfoBSTValue"); // css class
        Label lbl_LftB_BottomB_SrchTime_InfoHashMapValue = new Label("0 ms");
        lbl_LftB_BottomB_SrchTime_InfoHashMapValue.getStyleClass().add("lbl_LftB_BottomB_SrchTime_InfoHashMapValue"); // css class
        LftB_BottomB_SrchTimeHBox.getChildren().addAll(lbl_LftB_BottomB_SrchTime_Info, lbl_LftB_BottomB_SrchTime_InfoListValue, lbl_LftB_BottomB_SrchTime_InfoBSTValue, lbl_LftB_BottomB_SrchTime_InfoHashMapValue);    
        // width settings
        //------ Header line ------
        double firstColWidth = 120;
        double modelColWidth = 70;
        lbl_LftB_BottomB_Header_InfoEmptySpce.setPrefWidth(firstColWidth);
        lbl_LftB_BottomB_Header_InfoList.setPrefWidth(modelColWidth);
        lbl_LftB_BottomB_Header_InfoBST.setPrefWidth(modelColWidth);
        lbl_LftB_BottomB_Header_InfoHashMap.setPrefWidth(modelColWidth);
        //------ Training time line ------
        lbl_LftB_BottomB_TrainingTime_Info.setPrefWidth(firstColWidth);
        lbl_LftB_BottomB_TrainingTime_InfoListValue.setPrefWidth(modelColWidth);
        lbl_LftB_BottomB_TrainingTime_InfoBSTValue.setPrefWidth(modelColWidth);
        lbl_LftB_BottomB_TrainingTime_InfoHashMapValue.setPrefWidth(modelColWidth);
        //------ Search time line ------
        lbl_LftB_BottomB_SrchTime_Info.setPrefWidth(firstColWidth);
        lbl_LftB_BottomB_SrchTime_InfoListValue.setPrefWidth(modelColWidth);
        lbl_LftB_BottomB_SrchTime_InfoBSTValue.setPrefWidth(modelColWidth);
        lbl_LftB_BottomB_SrchTime_InfoHashMapValue.setPrefWidth(modelColWidth);

        // ======== column 1-3 (FLayerCenter): add VBox ========
        Label FLayerCenter_lbl_guide = new Label("Please enter a text to train the machine ");
        FLayerCenter_lbl_guide.getStyleClass().add("FLayerCenter_lbl_guide"); // css class
        Label FLayerCenter_lbl_seeSentence = new Label("See the text here:");
        FLayerCenter_lbl_seeSentence.getStyleClass().add("FLayerCenter_lbl_seeSentence"); // css class
        FlowPane FLayerCenter_FlowPane_sugestionArea = new FlowPane();
        FLayerCenter_FlowPane_sugestionArea.getStyleClass().add("FLayerCenter_FlowPane_sugestionArea"); // css class
        FLayerCenter_FlowPane_sugestionArea.setHgap(10); // horizontal gap between elements
        FLayerCenter_FlowPane_sugestionArea.setVgap(5); // vertical gap between elements
        // dimensions settings
        FLayerCenter_lbl_seeSentence.setPrefHeight(100); // set the preferred height
        FLayerCenter_lbl_seeSentence.setMaxWidth(Double.MAX_VALUE); // allow the see sentence label to grow horizontally and take up all available space        
        FLayerCenter_lbl_seeSentence.setPadding(new Insets(10)); // padding around the see sentence label
        
        VBox.setVgrow(FLayerCenter_FlowPane_sugestionArea, Priority.ALWAYS); // allow the flow pane to grow vertically and take up all available space
        FLayerCenter.setSpacing(15); // space between the guide label, the see sentence label, and the flow pane
        FLayerCenter.setPadding(new Insets(10)); // padding around the center layer
        FLayerCenter_lbl_guide.setPrefHeight(50); // set the preferred height of the guide label to 75 pixels        
        FLayerCenter_lbl_guide.setMaxWidth(Double.MAX_VALUE); // allow the guide label to grow horizontally and take up all available space
        FLayerCenter_lbl_guide.setPadding(new Insets(10));
        FLayerCenter_lbl_guide.setAlignment(Pos.CENTER); // center the text within the label
        FLayerCenter_lbl_seeSentence.setWrapText(true);
        FLayerCenter_lbl_seeSentence.setAlignment(Pos.TOP_LEFT); // align the text to the top left of the label
        // add to the center layer
        FLayerCenter.getChildren().addAll(FLayerCenter_lbl_guide, FLayerCenter_lbl_seeSentence, FLayerCenter_FlowPane_sugestionArea);
        
        // FLayerBottom
        TextArea FLayerBottom_TextArea = new TextArea();
        FLayerBottom_TextArea.getStyleClass().add("FLayerBottom_TextArea"); // css class
        FLayerBottom_TextArea.setPromptText("Enter your search prompt here...");
        VBox FLayerBottom_VBox = new VBox();
        FLayerBottom_VBox.getStyleClass().add("FLayerBottom_VBox"); // css class
        Button FLayerBottom_SubmitBtn = new Button("submit");
        FLayerBottom_SubmitBtn.getStyleClass().add("FLayerBottom_SubmitBtn"); // css class
        Button FLayerBottom_ClearBtn = new Button("clear");
        FLayerBottom_ClearBtn.getStyleClass().add("FLayerBottom_ClearBtn"); // css class
        Button FLayerBottom_DoneBtn = new Button("Done");
        FLayerBottom_DoneBtn.getStyleClass().add("FLayerBottom_DoneBtn"); // css class
        FLayerBottom_VBox.getChildren().addAll(FLayerBottom_SubmitBtn, FLayerBottom_ClearBtn, FLayerBottom_DoneBtn);
         // measure settings
        FLayerBottom_VBox.setSpacing(15); // space between the buttons
        FLayerBottom.setSpacing(15); // space between the text area and the buttons
        FLayerBottom_TextArea.setMaxWidth(Double.MAX_VALUE); // allow the text area to grow horizontally
        HBox.setHgrow(FLayerBottom_TextArea, Priority.ALWAYS); // allow the text area to take up all available horizontal space
        FLayerBottom_SubmitBtn.setPrefWidth(100); // set a fixed width for the submit button
        FLayerBottom_ClearBtn.setPrefWidth(100); // set a fixed width for the clear button
        FLayerBottom_DoneBtn.setPrefWidth(100); // set a fixed width for the done button
        // add to the bottom layer
        FLayerBottom.getChildren().addAll(FLayerBottom_TextArea, FLayerBottom_VBox);
        // secen setting 
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("styles.css").toExternalForm()
        );
        stage.setScene(scene);
        stage.show();




        // Machine Logic 
        enum AppStage {
            TRAINING,
            PREDICTION_INPUT,
            BUILDING
        }
    }
}

// =========================Documentation======================================

// name: 
// 1.FlayerLeft: first layer Left;
// -FLayerCenter: first layer right;
// -FLayerBottom: first layer bottom;

//===========================================================================
// JavaFx
// layout used gridpane : 4*4 table
// [0,0] [1,0] [2,0] [3,0]
// [0,1] [1,1] [2,1] [3,1]
// [0,2] [1,2] [2,2] [3,2]
// [0,3] [1,3] [2,3] [3,3]
//-----------pane addition (box to fill space)------------- 
// [LEFT] [CENTER][CENTER][CENTER]
// [LEFT] [CENTER][CENTER][CENTER]
// [LEFT] [CENTER][CENTER][CENTER]
// [LEFT] [      ][      ][      ]
