package TheSecretHistories.Content.Cards.Spirits;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public abstract class AbstractSpirit extends TemplateCustomCard {

    private static final CardColor COLOR = CULT_BLUE;

    public AbstractSpirit(String id, String imgName, int cost, CardType type, CardRarity rarity, CardTarget target) {
        super(id, imgName, cost, type, COLOR, rarity, target);
    }
}
