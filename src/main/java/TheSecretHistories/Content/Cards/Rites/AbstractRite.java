package TheSecretHistories.Content.Cards.Rites;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public abstract class AbstractRite extends TemplateCustomCard {

    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.RARE;

    public AbstractRite(String id, String imgName, int cost, CardType type, CardTarget target) {
        super(id, imgName, cost, type, COLOR, RARITY, target);
    }
}
