package TheSecretHistories.Content.Cards.Others;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;

public abstract class TemplateCustomCurseCard extends TemplateCustomCard {

    private static final int COST = -2;

    private static final CardType TYPE = CardType.CURSE;
    private static final CardColor COLOR = CardColor.CURSE;
    private static final CardRarity RARITY = CardRarity.CURSE;
    private static final CardTarget TARGET = CardTarget.NONE;

    public TemplateCustomCurseCard(String id, String imgName, int cost) {
        super(id, imgName, cost, TYPE, COLOR, RARITY, TARGET);
    }

    public TemplateCustomCurseCard(String id, String imgName) {
        super(id, imgName, COST, TYPE, COLOR, RARITY, TARGET);
    }
}
