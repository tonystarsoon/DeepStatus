package za.co.riggaroo.guide.tutorial;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import za.co.riggaroo.guide.GuideFragment;
import za.co.riggaroo.guide.TutorialItem;

/**
 * @author rebeccafranks
 * @since 15/11/09.
 */
public class GuidePresenter implements GuideContract.UserActionsListener {
    private final Context context;
    private GuideContract.View tutorialView;
    private List<GuideFragment> fragments;
    private List<TutorialItem> tutorialItems;

    public GuidePresenter(Context context, GuideContract.View tutorialView) {
        this.tutorialView = tutorialView;
        this.context = context;
    }

    @Override
    public void loadViewPagerFragments(List<TutorialItem> tutorialItems) {
        fragments = new ArrayList<>();
        this.tutorialItems = tutorialItems;
        for (int i = 0; i < tutorialItems.size(); i++) {
            GuideFragment helpTutorialImageFragment;
            helpTutorialImageFragment = GuideFragment.newInstance(tutorialItems.get(i), i);
            fragments.add(helpTutorialImageFragment);
        }
        tutorialView.setViewPagerFragments(fragments);
    }

    @Override
    public void doneOrSkipClick() {
        tutorialView.showEndTutorial();
    }

    @Override
    public void nextClick() {
        tutorialView.showNextTutorial();
    }

    @Override
    public void onPageSelected(int pageNo) {
        if (pageNo >= fragments.size() - 1) {
            tutorialView.showDoneButton();
        } else {
            tutorialView.showSkipButton();
        }
    }

    @Override
    public void transformPage(View page, float position) {
        int pagePosition = (int) page.getTag();
        if (position <= -1.0f || position >= 1.0f) {

        } else if (position == 0.0f) {
            tutorialView.setBackgroundColor(ContextCompat.getColor(context, tutorialItems.get(pagePosition).getBackgroundColor()));
        } else {
            fadeNewColorIn(pagePosition, position);
        }
    }

    @Override
    public int getNumberOfTutorials() {
        if (tutorialItems != null) {
            return tutorialItems.size();
        }
        return 0;
    }

    private void fadeNewColorIn(int index, float multiplier) {
        if (multiplier < 0) {

            int colorStart = ContextCompat.getColor(context, tutorialItems.get(index).getBackgroundColor());
            if (index + 1 == fragments.size()) {
                tutorialView.setBackgroundColor(colorStart);
                return;
            }
            int colorEnd = ContextCompat.getColor(context, tutorialItems.get(index + 1).getBackgroundColor());
            int colorToSet = (int) (new ArgbEvaluator().evaluate(Math.abs(multiplier), colorStart, colorEnd));
            tutorialView.setBackgroundColor(colorToSet);
        }
    }
}





