package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelCard;
import TheSecretHistories.Data.MultiLevelCardStrings;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FRAGMENT;

public abstract class AbstractFragment extends TemplateMultiLevelCard {

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    public AbstractFragment(String id, CardTags principleTag) {
        super(id, COST, TYPE, COLOR, RARITY, TARGET, 6);

        this.tags.add(FRAGMENT);
        this.tags.add(principleTag);

        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeMagicNumber(2);
    }
}
