package za.co.riggaroo.guide.tutorial;

import java.util.List;

import za.co.riggaroo.guide.GuideFragment;
import za.co.riggaroo.guide.TutorialItem;

/**
 * @author rebeccafranks
 * @since 15/11/09.
 */
public interface GuideContract {

    interface View {
        void showNextTutorial();
        void showEndTutorial();
        void setBackgroundColor(int color);
        void showDoneButton();
        void showSkipButton();
        void setViewPagerFragments(List<GuideFragment> materialTutorialFragments);
    }

    interface UserActionsListener {
        void loadViewPagerFragments(List<TutorialItem> tutorialItems);
        void doneOrSkipClick();
        void nextClick();
        void onPageSelected(int pageNo);
        void transformPage(android.view.View page, float position);

        int getNumberOfTutorials();
    }

}
