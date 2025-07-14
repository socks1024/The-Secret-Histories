package TheSecretHistories.Content.Cards.Template;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class TemplateMultiLevelOptionCard extends TemplateMultiLevelCard {

    private static final int COST = -2;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;

    public TemplateMultiLevelOptionCard(String id, CardColor color, int upgradeTimesLimit) {
        super(id, COST, TYPE, color, RARITY, TARGET, upgradeTimesLimit);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }

    @Override
    public void onChoseThisOption(){}
}
