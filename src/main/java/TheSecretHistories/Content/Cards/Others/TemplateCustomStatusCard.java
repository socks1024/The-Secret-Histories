package TheSecretHistories.Content.Cards.Others;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;

public abstract class TemplateCustomStatusCard extends TemplateCustomCard {

    private static final int COST = -2;

    private static final CardType TYPE = CardType.STATUS;
    private static final CardColor COLOR = CardColor.COLORLESS;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.NONE;

    public TemplateCustomStatusCard(String id, String imgName, int cost) {
        super(id, imgName, cost, TYPE, COLOR, RARITY, TARGET);
    }

    public TemplateCustomStatusCard(String id, String imgName) {
        super(id, imgName, COST, TYPE, COLOR, RARITY, TARGET);
    }
}
