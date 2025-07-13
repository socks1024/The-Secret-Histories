package TheSecretHistories.Content.Cards.Template;

import TheSecretHistories.Data.MultiLevelCardStrings;

public abstract class TemplateMultiLevelCard extends TemplateCustomCard{

    private final MultiLevelCardStrings multiLevelCardStrings;

    protected final int upgradeTimesLimit;

    public TemplateMultiLevelCard(String id, MultiLevelCardStrings cardStrings, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target,int upgradeTimesLimit) {
        super(id, cardStrings.NAMES[0], cardStrings.IMG_PATHS[0], cost, cardStrings.DESCRIPTION[0], type, color, rarity, target);

        multiLevelCardStrings = cardStrings;

        this.upgradeTimesLimit = upgradeTimesLimit;
    }

    public TemplateMultiLevelCard(String id, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target,int upgradeTimesLimit) {
        this(id, MultiLevelCardStrings.GetMultiLevelCardString(id), cost, type, color, rarity, target, upgradeTimesLimit);
    }

    @Override
    public void upgrade() {

        if (!upgraded) {
            if (timesUpgraded < upgradeTimesLimit){

                OnUpgrade(timesUpgraded);

                this.timesUpgraded ++;

                RefreshUI();

                if (timesUpgraded == upgradeTimesLimit) {
                    upgraded = true;
                }
            }
        }
    }

    private void RefreshUI(){

        if (multiLevelCardStrings == null) return;

        if (timesUpgraded < multiLevelCardStrings.NAMES.length) {
            this.name = multiLevelCardStrings.NAMES[timesUpgraded];
        }

        if (timesUpgraded < multiLevelCardStrings.IMG_PATHS.length) {
            this.assetUrl = MakeCardImgPath(type, multiLevelCardStrings.IMG_PATHS[timesUpgraded]);
        }

        if (timesUpgraded < multiLevelCardStrings.DESCRIPTION.length) {
            this.rawDescription = multiLevelCardStrings.DESCRIPTION[timesUpgraded];
        }

        initializeTitle();
        loadCardImage(assetUrl);
    }
}
