package TheSecretHistories.Content.Cards.Template;

import TheSecretHistories.Data.MultiLevelCardStrings;

public abstract class TemplateMultiLevelCard extends TemplateCustomCard{

    private MultiLevelCardStrings multiLevelCardStrings;

    protected int upgradeTimesLimit = 0;

    public TemplateMultiLevelCard(String id, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target,int upgradeTimesLimit) {
        super(id, MultiLevelCardStrings.GetMultiLevelCardString(id).NAMES[0], MultiLevelCardStrings.GetMultiLevelCardString(id).IMG_PATHS[0], cost, MultiLevelCardStrings.GetMultiLevelCardString(id).DESCRIPTIONS[0],type, color, rarity, target);

        multiLevelCardStrings = MultiLevelCardStrings.GetMultiLevelCardString(id);

        this.upgradeTimesLimit = upgradeTimesLimit;
    }

    @Override
    public void upgrade() {

        if (!upgraded) upgraded = true;

        if (timesUpgraded < upgradeTimesLimit){

            OnUpgrade(timesUpgraded);

            this.timesUpgraded ++;

            RefreshUI();
        }
    }

    private void RefreshUI(){

        if (multiLevelCardStrings == null) return;

        if (timesUpgraded < multiLevelCardStrings.NAMES.length) {
            this.name = multiLevelCardStrings.NAMES[timesUpgraded];
        }

        if (timesUpgraded < multiLevelCardStrings.IMG_PATHS.length) {
            this.assetUrl = multiLevelCardStrings.IMG_PATHS[timesUpgraded];
        }

        if (timesUpgraded < multiLevelCardStrings.DESCRIPTIONS.length) {
            this.assetUrl = multiLevelCardStrings.DESCRIPTIONS[timesUpgraded];
        }

        initializeTitle();
        loadCardImage(assetUrl);
    }
}
